package tags.floyd_warshall

/**
 * https://www.acmicpc.net/problem/2660
 */
fun main() {
    val n = readln().toInt()
    val distances = getDistances(n)

    val scores = IntArray(n + 1) { i ->
        (1..n)
            .filter { j -> distances[i][j] != 1_000_000 }
            .maxOfOrNull { j -> distances[i][j] } ?: 1_000_000
    }

    val score = scores.min()
    if (score == 1_000_000) {
        val candidates = (1..n).toList()
        println("0 $n")
        println(candidates.joinToString(" "))
    } else {
        val candidates = (1..n).filter { i -> scores[i] == score }
        println("$score ${candidates.size}")
        println(candidates.joinToString(" "))
    }
}

private fun getDistances(n: Int): Array<IntArray> {
    val distances = Array(n + 1) { IntArray(n + 1) { 1_000_000 } }
    (1..n).forEach { i -> distances[i][i] = 0 }

    while (true) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        if (src == -1 && dst == -1) {
            break
        }
        distances[src][dst] = 1
        distances[dst][src] = 1
    }


    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                distances[i][j] = distances[i][j].coerceAtMost(distances[i][k] + distances[k][j])
            }
        }
    }
    return distances
}
