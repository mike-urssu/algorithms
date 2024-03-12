package tags.math

/**
 * https://www.acmicpc.net/problem/9325
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val s = readln().toInt()
        val n = readln().toInt()
        val sum = s + (1..n).sumOf {
            val (q, p) = readln().split(" ").map { it.toInt() }
            q * p
        }
        println(sum)
    }
}
