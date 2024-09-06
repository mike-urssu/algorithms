package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/16937
 */
fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    val n = readln().toInt()
    val stickers = Array(n) { readln().split(" ").map { it.toInt() } }

    var max = 0
    for (i in 0 until n) {
        val (r1, c1) = stickers[i]
        for (j in 0 until n) {
            if (i == j) {
                continue
            }

            val (r2, c2) = stickers[j]
            if (isValid(h, w, r1, c1, r2, c2)) {
                max = max.coerceAtLeast((r1 * c1) + (r2 * c2))
            }
        }
    }

    println(max)
}

private fun isValid(h: Int, w: Int, r1: Int, c1: Int, r2: Int, c2: Int): Boolean {
    if (r1 <= h && c1 <= w) {
        if (r2 <= h - r1 && c2 <= w) {
            return true
        }
        if (r2 <= h && c2 <= w - c1) {
            return true
        }

        if (c2 <= h - r1 && r2 <= w) {
            return true
        }
        if (c2 <= h && r2 <= w - c1) {
            return true
        }
    }

    if (c1 <= h && r1 <= w) {
        if (r2 <= h - c1 && c2 <= w) {
            return true
        }
        if (r2 <= h && c2 <= w - r1) {
            return true
        }

        if (c2 <= h - c1 && r2 <= w) {
            return true
        }
        if (c2 <= h && r2 <= w - r1) {
            return true
        }
    }
    return false
}
