package tags.math

/**
 * https://www.acmicpc.net/problem/4892
 */
fun main() {
    var t = 1
    while (true) {
        val n0 = readln().toInt()
        if (n0 == 0) {
            break
        }

        val n1 = 3 * n0
        val n2 = if (n1 % 2 == 0) {
            n1 / 2
        } else {
            (n1 + 1) / 2
        }
        val n3 = 3 * n2
        val n4 = n3 / 9

        if (n1 % 2 == 0) {
            println("$t. even $n4")
        } else {
            println("$t. odd $n4")
        }
        t++
    }
}
