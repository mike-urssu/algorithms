package tags.math

/**
 * https://www.acmicpc.net/problem/11948
 */
fun main() {
    val scores1 = (0 until 4).map { readln().toInt() }.sortedDescending()
    val scores2 = (0 until 2).map { readln().toInt() }.sortedDescending()
    val sum = scores1.take(3).sum() + scores2[0]
    println(sum)
}
