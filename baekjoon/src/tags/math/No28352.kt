package tags.math

/**
 * https://www.acmicpc.net/problem/28352
 */
fun main() {
    val n = readln().toLong()
    val factorial = (1..n).reduce { acc, l -> acc * l }
    val week = factorial / 604_800
    println(week)
}
