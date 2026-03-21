package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/16283
 */
fun main() {
    val (a, b, n, w) = readln().split(" ").map { it.toInt() }
    val counts = intArrayOf(-1, -1)
    for (sheep in 1 until n) {
        val goat = n - sheep
        if (a * sheep + b * goat == w) {
            if (counts[0] == -1) {
                counts[0] = sheep
                counts[1] = goat
            } else {
                println(-1)
                return
            }
        }
    }

    if (counts[0] == -1) {
        println(-1)
    } else {
        println("${counts[0]} ${counts[1]}")
    }
}
