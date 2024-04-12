package tags.implementation

/**
 * https://www.acmicpc.net/problem/1408
 */
fun main() {
    val (h1, m1, s1) = readln().split(":").map { it.toInt() }
    val (h2, m2, s2) = readln().split(":").map { it.toInt() }

    val seconds = if (compare(h1, m1, s1, h2, m2, s2)) {
        getSeconds(h1, m1, s1, h2, m2, s2)
    } else {
        24 * 60 * 60 + getSeconds(h1, m1, s1, h2, m2, s2)
    }

    val h = seconds / 3600
    val m = seconds % 3600 / 60
    val s = seconds % 60
    println("${String.format("%02d", h)}:${String.format("%02d", m)}:${String.format("%02d", s)}")
}

private fun compare(h1: Int, m1: Int, s1: Int, h2: Int, m2: Int, s2: Int): Boolean {
    return if (h2 > h1) {
        true
    } else if (h2 == h1) {
        if (m2 > m1) {
            true
        } else if (m2 == m1) {
            s2 >= s1
        } else {
            false
        }
    } else {
        false
    }
}

private fun getSeconds(h1: Int, m1: Int, s1: Int, h2: Int, m2: Int, s2: Int) =
    (h2 * 3600 + m2 * 60 + s2) - (h1 * 3600 + m1 * 60 + s1)
