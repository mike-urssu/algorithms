package tags.math

/**
 * https://www.acmicpc.net/problem/11024
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val sum = readln().split(" ").sumOf { it.toInt() }
        println(sum)
    }
}
