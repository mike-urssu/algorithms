package tags.implementation

/**
 * https://www.acmicpc.net/problem/10797
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    println(numbers.count { it == n })
}
