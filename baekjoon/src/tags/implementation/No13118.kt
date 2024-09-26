package tags.implementation

/**
 * https://www.acmicpc.net/problem/13118
 */
fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    val (x, _, _) = readln().split(" ").map { it.toInt() }
    println(numbers.indexOf(x) + 1)
}
