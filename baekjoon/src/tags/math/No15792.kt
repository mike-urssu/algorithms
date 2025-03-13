package tags.math

/**
 * https://www.acmicpc.net/problem/15792
 */
fun main() {
    var (a, b) = readln().split(" ").map { it.toInt() }
    val output = StringBuilder("${a / b}.")
    a %= b
    var float = 0
    while (a != 0 && float++ < 1000) {
        output.append(a * 10 / b)
        a = a * 10 % b
    }
    println(output)
}
