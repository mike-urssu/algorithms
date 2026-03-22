package tags.math

/**
 * https://www.acmicpc.net/problem/24860
 */
fun main() {
    val (v1, j1) = readln().split(" ").map(String::toLong)
    val (v2, j2) = readln().split(" ").map(String::toLong)
    val (v3, d3, j3) = readln().split(" ").map(String::toLong)
    println((v1 * j1 + v2 * j2) * v3 * d3 * j3)
}
