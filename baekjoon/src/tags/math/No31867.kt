package tags.math

/**
 * https://www.acmicpc.net/problem/31867
 */
fun main() {
    val n = readln().toInt()
    val k = readln()
    val even = k.count { it.digitToInt() % 2 == 0 }
    val odd = n - even
    val result = if (even > odd) {
        0
    } else if (even < odd) {
        1
    } else {
        -1
    }
    println(result)
}
