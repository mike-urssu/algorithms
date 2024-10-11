package tags.math

/**
 * https://www.acmicpc.net/problem/2033
 */
fun main() {
    var n = readln().toInt()
    var t = 10
    while (true) {
        if (n < t) {
            break
        }

        n = if (n % t < 5 * t / 10) {
            (n / t) * t
        } else {
            (n / t + 1) * t
        }
        t *= 10
    }
    println(n)
}
