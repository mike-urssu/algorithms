package tags.math

/**
 * https://www.acmicpc.net/problem/21312
 */
fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    if (numbers.all { it % 2 == 0 }) {
        println(numbers.reduce { acc, i -> acc * i })
    } else {
        println(numbers.filter { it % 2 != 0 }.reduce { acc, i -> acc * i })
    }
}
