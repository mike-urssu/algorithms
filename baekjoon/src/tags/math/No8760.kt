package tags.math

/**
 * https://www.acmicpc.net/problem/8760
 */
fun main() {
    val z = readln().toInt()
    repeat(z) {
        val (w, k) = readln().split(" ").map { it.toInt() }
        println(w * k / 2)
    }
}
