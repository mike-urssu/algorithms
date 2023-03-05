package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/27590
 */
fun main() {
    val (ds, ys) = readln().split(" ").map { it.toInt() }
    val (dm, ym) = readln().split(" ").map { it.toInt() }

    var sun = -ds
    var moon = -dm
    while (true) {
        if (sun == moon) {
            break
        } else if (sun > moon) {
            moon += ym
        } else {
            sun += ys
        }
    }
    println(sun)
}
