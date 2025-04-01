package tags.math

/**
 * https://www.acmicpc.net/problem/29863
 */
fun main() {
    val n1 = readln().toInt()
    val n2 = readln().toInt()
    if (n1 in 20..23) {
        println(n2 + 24 - n1)
    } else {
        println(n2 - n1)
    }
}
