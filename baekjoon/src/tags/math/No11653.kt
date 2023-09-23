package tags.math

/**
 * https://www.acmicpc.net/problem/11653
 */
fun main() {
    val n = readln().toInt()
    if (n != 1) {
        var v = n
        var i = 2
        while (v != 1) {
            if (v % i == 0) {
                println(i)
                v /= i
            } else {
                i++
            }
        }
    }
}
