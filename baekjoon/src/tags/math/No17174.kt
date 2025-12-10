package tags.math

/**
 * https://www.acmicpc.net/problem/17174
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var count = n
    var mul = m
    while (n >= mul) {
        count += n / mul
        mul *= m
    }
    println(count)
}
