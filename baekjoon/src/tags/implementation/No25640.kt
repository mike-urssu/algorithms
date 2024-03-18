package tags.implementation

/**
 * https://www.acmicpc.net/problem/25640
 */
fun main() {
    val mbti = readln()
    val n = readln().toInt()
    println((1..n).count { readln() == mbti })
}
