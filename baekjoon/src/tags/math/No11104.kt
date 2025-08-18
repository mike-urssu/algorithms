package tags.math

/**
 * https://www.acmicpc.net/problem/11104
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val binary = readln()
        println(binary.toInt(2))
    }
}
