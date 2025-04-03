package tags.math

/**
 * https://www.acmicpc.net/problem/15633
 */
fun main() {
    val n = readln().toInt()
    val sum = (1..n).filter { n % it == 0 }.sum()
    println(sum * 5 - 24)
}
