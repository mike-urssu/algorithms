package tags.math

/**
 * https://www.acmicpc.net/problem/9713
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val sum = (1..n).filter { it % 2 == 1 }.sum()
        println(sum)
    }
}
