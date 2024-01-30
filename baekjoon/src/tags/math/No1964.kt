package tags.math

/**
 * https://www.acmicpc.net/problem/1964
 */
fun main() {
    val n = readln().toInt()
    var points = 1
    var l = 2
    var m = 0
    repeat(n) {
        points = (points + (l * 2 + m)) % 45678
        l++
        m++
    }
    println(points)
}
