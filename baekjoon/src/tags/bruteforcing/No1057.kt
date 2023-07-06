package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1057
 */
fun main() {
    var (_, a, b) = readln().split(" ").map { it.toInt() }
    var round = 0
    while (a != b) {
        a = (a + 1) / 2
        b = (b + 1) / 2
        round++
    }
    println(round)
}
