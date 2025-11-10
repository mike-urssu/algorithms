package tags.math

/**
 * https://www.acmicpc.net/problem/9546
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val k = readln().toInt()
        println((1 shl k) - 1)
    }
}
