package tags.math

/**
 * https://www.acmicpc.net/problem/28097
 */
fun main() {
    val n = readln().toInt()
    val hours = readln().split(" ").map { it.toInt() }
    val sum = hours.sum() + ((n - 1) shl 3)
    println("${sum / 24} ${sum % 24}")
}
