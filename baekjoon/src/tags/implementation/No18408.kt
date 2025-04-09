package tags.implementation

/**
 * https://www.acmicpc.net/problem/18408
 */
fun main() {
    val digits = readln().split(" ").map { it.toInt() }
    val one = digits.count { it == 1 }
    val two = 3 - one
    if (one > two) {
        println(1)
    } else {
        println(2)
    }
}
