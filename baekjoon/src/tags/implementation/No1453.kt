package tags.implementation

/**
 * https://www.acmicpc.net/problem/1453
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    println(n - numbers.distinct().size)
}
