package tags.string

/**
 * https://www.acmicpc.net/problem/10822
 */
fun main() {
    val sum = readln().split(",").sumOf { it.toInt() }
    println(sum)
}
