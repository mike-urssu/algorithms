package tags.math

/**
 * https://www.acmicpc.net/problem/2456
 */
fun main() {
    val n = readln().toInt()
    val scores = Array(n) { readln().split(" ").map { it.toInt() } }
    val prefixSum = IntArray(4)
    scores.forEach { (a, b, c) ->
        prefixSum[1] += a
        prefixSum[2] += b
        prefixSum[3] += c
    }

    val max = prefixSum.max()
    val count = prefixSum.count { it == max }
    val winner = if (count != 1) {
        val counts = Array(4) { IntArray(4) }
        scores.forEach { (a, b, c) ->
            counts[1][a]++
            counts[2][b]++
            counts[3][c]++
        }

        val s3 = find(counts, listOf(1, 2, 3), 3)
        if (s3.size == 1) {
            s3[0]
        } else {
            val s2 = find(counts, s3, 2)
            if (s2.size == 1) {
                s2[0]
            } else {
                0
            }
        }
    } else {
        prefixSum.indexOf(max)
    }
    println("$winner $max")
}

private fun find(counts: Array<IntArray>, students: List<Int>, score: Int): List<Int> {
    val max = (1..3).maxOf { counts[it][score] }
    return students.filter { s -> counts[s][score] == max }
}
