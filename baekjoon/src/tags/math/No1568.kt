package tags.math

/**
 * https://www.acmicpc.net/problem/1568
 */
fun main() {
    val n = readln().toInt()

    var second = 0
    var bird = n
    var i = 1
    while (bird > 0) {
        if (i <= bird) {
            bird -= i++
            second++
        } else {
            i = 1
        }
    }
    println(second)
}
