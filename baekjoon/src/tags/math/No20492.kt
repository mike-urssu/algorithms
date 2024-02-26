package tags.math

/**
 * https://www.acmicpc.net/problem/20492
 */
fun main() {
    val n = readln().toInt()
    println("${n * 78 / 100} ${n * 80 / 100 + n * 20 / 100 * 78 / 100}")
}
