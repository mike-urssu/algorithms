package tags.math

/**
 * https://www.acmicpc.net/problem/15734
 */
fun main() {
    var (l, r, a) = readln().split(" ").map { it.toInt() }
    if (l < r) {
        while (l != r && a != 0) {
            l++
            a--
        }
    } else {
        while (l != r && a != 0) {
            r++
            a--
        }
    }
    while (a >= 2) {
        l++
        r++
        a -= 2
    }
    println(minOf(l, r) * 2)
}
