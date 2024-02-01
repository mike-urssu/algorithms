package tags.math

/**
 * https://www.acmicpc.net/problem/3058
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val evens = readln().split(" ").map { it.toInt() }.filter { it % 2 == 0 }
        println("${evens.sum()} ${evens.min()}")
    }
}
