package tags.math

/**
 * https://www.acmicpc.net/problem/13416
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        var sum = 0
        repeat(n) {
            val (a, b, c) = readln().split(" ").map { it.toInt() }
            sum += maxOf(a, b, c, 0)
        }
        println(sum)
    }
}
