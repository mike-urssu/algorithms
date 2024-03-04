package tags.math

/**
 * https://www.acmicpc.net/problem/17256
 */
fun main() {
    val (ax, ay, az) = readln().split(" ").map { it.toInt() }
    val (cx, cy, cz) = readln().split(" ").map { it.toInt() }
    println("${cx - az} ${cy / ay} ${cz - ax}")
}
