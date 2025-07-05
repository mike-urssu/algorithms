package tags.greedy

/**
 * https://www.acmicpc.net/problem/19539
 */
fun main() {
    readln()
    val heights = readln().split(" ").map { it.toInt() }
    val sum = heights.sum()
    val isValid = if (sum % 3 != 0) {
        "NO"
    } else if (sum / 3 > heights.sumOf { it / 2 }) {
        "NO"
    } else {
        "YES"
    }
    println(isValid)
}
