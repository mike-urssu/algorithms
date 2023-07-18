package tags.sorting

/**
 * https://www.acmicpc.net/problem/5800
 */
fun main() {
    val k = readln().toInt()
    repeat(k) { i ->
        val scores = getScores()
        println("Class ${i + 1}")
        println("Max ${scores.first()}, Min ${scores.last()}, Largest gap ${getLargestGap(scores)}")
    }
}

private fun getScores(): IntArray {
    val numbers = readln().split(" ").map { it.toInt() }
    val n = numbers[0]
    return numbers.subList(1, n + 1).sortedDescending().toIntArray()
}

private fun getLargestGap(scores: IntArray) =
        (0 until scores.lastIndex).maxOf { i -> scores[i] - scores[i + 1] }
