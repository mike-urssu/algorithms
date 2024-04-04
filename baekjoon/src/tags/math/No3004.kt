package tags.math

/**
 * https://www.acmicpc.net/problem/3004
 */
fun main() {
    val n = readln().toInt()
    var a = 1
    var b = 1
    repeat(n) {
        if (a == b) {
            a++
        } else {
            b++
        }
    }
    println(a * b)
}
