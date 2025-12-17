package tags.sorting

/**
 * https://www.acmicpc.net/problem/6986
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val scores = Array(n) { readln().toDouble() }.sortedDescending()

    val trimmedAverage = scores.subList(k, n - k).average()
    val calibratedAverage = (scores.subList(k, n - k).sum() + scores[k] * k + scores[n - k - 1] * k) / n
    println(String.format("%.02f", trimmedAverage))
    println(String.format("%.02f", calibratedAverage))
}
