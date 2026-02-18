package tags.ad_hoc

/**
 * https://www.acmicpc.net/problem/4307
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (l, n) = readln().split(" ").map { it.toInt() }
        val positions = IntArray(n) { readln().toInt() }
        val max = positions.maxOf { maxOf(it, l - it) }
        val min = positions.maxOf { minOf(it, l - it) }
        println("$min $max")
    }
}
