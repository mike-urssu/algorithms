package tags.implementation

/**
 * https://www.acmicpc.net/problem/14909
 */
fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    println(numbers.count { it > 0 })
}
