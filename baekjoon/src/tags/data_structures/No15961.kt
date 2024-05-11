package tags.data_structures

/**
 * https://www.acmicpc.net/problem/15961
 */
private val reader = System.`in`.bufferedReader()

fun main() {
    val (n, d, k, c) = reader.readLine().split(" ").map { it.toInt() }
    val foods = IntArray(n) { reader.readLine().toInt() }
    val counts = IntArray(d + 1)
    var count = 0

    var left = 0
    var right = 0
    var max: Int

    repeat(k) { i ->
        if (counts[foods[i]] == 0) {
            count++
        }
        counts[foods[i]]++
        right++
    }
    max = count

    repeat(n) {
        if (counts[foods[left]] == 1) {
            count--
        }
        counts[foods[left]]--

        if (counts[foods[right]] == 0) {
            count++
        }
        counts[foods[right]]++

        left = (left + 1) % n
        right = (right + 1) % n

        max = if (counts[c] == 0) {
            max.coerceAtLeast(count + 1)
        } else {
            max.coerceAtLeast(count)
        }
    }
    println(max)
}
