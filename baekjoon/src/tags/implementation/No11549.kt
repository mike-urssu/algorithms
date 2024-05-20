package tags.implementation

/**
 * https://www.acmicpc.net/problem/11549
 */
fun main() {
    val t = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    println(numbers.count { it == t })
}
