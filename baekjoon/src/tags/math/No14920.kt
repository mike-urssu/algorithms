package tags.math

/**
 * https://www.acmicpc.net/problem/14920
 */
fun main() {
    var c = readln().toLong()
    var n = 1
    while (true) {
        if (c == 1L) {
            break
        }
        c = if (c % 2 == 0L) {
            c / 2
        } else {
            c * 3 + 1
        }
        n++
    }
    println(n)
}
