package tags.math

/**
 * https://www.acmicpc.net/problem/11109
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (d, n, s, p) = readln().split(" ").map { it.toInt() }
        val serial = n * s
        val parallel = d + n * p
        if (serial < parallel) {
            println("do not parallelize")
        } else if (serial > parallel) {
            println("parallelize")
        } else {
            println("does not matter")
        }
    }
}
