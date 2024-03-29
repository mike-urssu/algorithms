package tags.implementation

/**
 * https://www.acmicpc.net/problem/3047
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }.sorted()
    val input = readln()
    val abcInOrder = input.map {
        when (it) {
            'A' -> a
            'B' -> b
            else -> c
        }
    }
    println(abcInOrder.joinToString(" "))
}
