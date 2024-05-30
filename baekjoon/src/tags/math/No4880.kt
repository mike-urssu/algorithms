package tags.math

/**
 * https://www.acmicpc.net/problem/4880
 */
fun main() {
    while (true) {
        val (a1, a2, a3) = readln().split(" ").map { it.toInt() }
        if (a1 == 0 && a2 == 0 && a3 == 0) {
            break
        }
        if (a2 - a1 == a3 - a2) {
            println("AP ${a3 + a3 - a2}")
        } else {
            println("GP ${a3 * a3 / a2}")
        }
    }
}
