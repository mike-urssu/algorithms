package tags.implementation

/**
 * https://www.acmicpc.net/problem/9017
 */
private var n = 0
private lateinit var teams: IntArray
private lateinit var counts: IntArray
private lateinit var mappedScores: IntArray
private lateinit var scores: IntArray

fun main() {
    val t = readln().toInt()
    repeat(t) {
        n = readln().toInt()
        teams = readln().split(" ").map { it.toInt() }.toIntArray()

        counts = countTeams()
        mappedScores = mapScores()
        scores = sumScores()

        val min = scores.filter { it != 0 }.min()
        val minCount = scores.count { it == min }
        if (minCount == 1) {
            println(scores.indexOf(min))
        } else {
            val indices = (1..200).filter { scores[it] == min }
            val minIndex = indices.minOf { i -> (0 until n).filter { teams[it] == i }[4] }
            println(teams[minIndex])
        }
    }
}

private fun countTeams(): IntArray {
    val counts = IntArray(201)
    teams.forEach { counts[it]++ }
    return counts
}

private fun mapScores(): IntArray {
    var score = 1
    val mappedScores = IntArray(n)
    teams.forEachIndexed { i, v ->
        mappedScores[i] = if (counts[v] != 6) {
            0
        } else {
            score++
        }
    }
    return mappedScores
}

private fun sumScores(): IntArray {
    val scores = IntArray(201)
    (1..200).forEach { i ->
        if (counts[i] == 6) {
            val indices = (0 until n).filter { j -> teams[j] == i }.take(4)
            scores[i] = indices.sumOf { mappedScores[it] }
        }
    }
    return scores
}
