package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/7782
 */
fun main() {
    val n = readln().toInt()
    val (b1, b2) = readln().split(" ").map { it.toInt() }

    var isLanded = false
    repeat(n) {
        val (lx, ly, hx, hy) = readln().split(" ").map { it.toInt() }
        if (b1 in lx..hx && b2 in ly..hy) {
            isLanded = true
        }
    }

    if (isLanded) {
        println("Yes")
    } else {
        println("No")
    }
}
