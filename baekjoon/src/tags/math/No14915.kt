package tags.math

/**
 * https://www.acmicpc.net/problem/14915
 */
fun main() {
    val (m, n) = readln().split(" ").map(String::toInt)
    println(m.toString(n).uppercase())
}
