package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/14912
 */
fun main() {
    val (n, d) = readln().split(" ").map { it.toInt() }
    val count = (1..n).sumOf { i -> i.toString().count { it.digitToInt() == d } }
    println(count)
}
