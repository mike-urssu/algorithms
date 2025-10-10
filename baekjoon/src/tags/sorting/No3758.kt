package tags.sorting

/**
 * https://www.acmicpc.net/problem/3758
 */
private lateinit var logs: Array<Triple<Int, Int, Int>>
private lateinit var graph: Array<Array<MutableList<Int>>>
private lateinit var scores: IntArray

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, k, t, m) = readln().split(" ").map { it.toInt() }
        logs = getLogs(m)
        graph = getGraph(n, k)
        scores = calculateScores(n)
        println(getRanking(scores, n, t))
    }
}

private fun getLogs(m: Int): Array<Triple<Int, Int, Int>> {
    return Array(m) {
        val (i, j, s) = readln().split(" ").map { it.toInt() }
        Triple(i, j, s)
    }
}

private fun getGraph(n: Int, k: Int): Array<Array<MutableList<Int>>> {
    val graph = Array(n + 1) { Array(k + 1) { mutableListOf<Int>() } }
    logs.forEach { (i, j, s) -> graph[i][j].add(s) }
    return graph
}

private fun calculateScores(n: Int): IntArray {
    val sum = IntArray(n + 1)
    graph.forEachIndexed { i, problem ->
        problem.forEach { scores ->
            sum[i] += scores.maxOrNull() ?: 0
        }
    }
    return sum
}

private fun getRanking(scores: IntArray, n: Int, k: Int): Int {
    var ranking = 1
    for (i in 1..n) {
        if (i == k) {
            continue
        }
        if (scores[k] < scores[i]) {
            ranking++
        } else if (scores[k] == scores[i]) {
            val submitK = graph[k].sumOf { it.size }
            val submitI = graph[i].sumOf { it.size }
            if (submitK > submitI) {
                ranking++
            } else if (submitK == submitI) {
                ranking += compareLastLog(k, i)
            }
        }
    }
    return ranking
}

private fun compareLastLog(k: Int, i: Int): Int {
    val indexK = logs.indexOfLast { it.first == k }
    val indexI = logs.indexOfLast { it.first == i }
    return if (indexK > indexI) {
        1
    } else {
        0
    }
}
