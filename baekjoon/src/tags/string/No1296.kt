package tags.string

/**
 * https://www.acmicpc.net/problem/1296
 */
fun main() {
    val name = readln()
    val n = readln().toInt()
    val team = Array(n) { readln() }

    val scores: IntArray = getScores(n, name, team)
    val max: Int = scores.max()
    val names = team.filterIndexed { i, _ -> scores[i] == max }
    println(names.minOf { it })
}

private fun getScores(n: Int, name: String, team: Array<String>): IntArray {
    val score = getScore(name)
    return IntArray(n) { i ->
        val teamScore = getScore(team[i])
        val totalScore = IntArray(4) { j -> score[j] + teamScore[j] }
        calculateTotalScore(totalScore)
    }
}

private fun getScore(name: String) =
    IntArray(4).apply {
        name.forEach {
            when (it) {
                'L' -> this[0]++
                'O' -> this[1]++
                'V' -> this[2]++
                'E' -> this[3]++
            }
        }
    }

private fun calculateTotalScore(score: IntArray): Int {
    val l = score[0]
    val o = score[1]
    val v = score[2]
    val e = score[3]
    return ((l + o) * (l + v) * (l + e) * (o + v) * (o + e) * (v + e)) % 100
}
