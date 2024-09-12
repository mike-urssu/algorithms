package tags.math

/**
 * https://www.acmicpc.net/problem/12866
 */
fun main() {
    readln()
    val s = readln()

    val counts = LongArray(4)
    s.forEach {
        when (it) {
            'A' -> counts[0]++
            'C' -> counts[1]++
            'G' -> counts[2]++
            'T' -> counts[3]++
        }
    }

    var mod = 1L
    (0 until 4).forEach { mod = (mod * counts[it]) % 1_000_000_007 }
    println(mod)
}
