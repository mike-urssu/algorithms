package tags.string

/**
 * https://www.acmicpc.net/problem/5524
 */
fun main() {
    val n = readln().toInt()
    val names = Array(n) { readln() }
    names.forEach { println(it.lowercase()) }
}
