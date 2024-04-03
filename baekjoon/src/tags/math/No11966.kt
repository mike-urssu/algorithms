package tags.math

/**
 * https://www.acmicpc.net/problem/11966
 */
fun main() {
    val n = readln().toInt()
    if (Integer.toBinaryString(n).count { it == '1' } == 1) {
        println(1)
    } else {
        println(0)
    }
}
