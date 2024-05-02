package tags.math

/**
 * https://www.acmicpc.net/problem/2921
 */
fun main() {
    val prefixSum = (1..1000).runningFold(0, Int::plus)
    val n = readln().toInt()
    val sum = (1..n).sumOf { i -> prefixSum[i] } * 3
    println(sum)
}
