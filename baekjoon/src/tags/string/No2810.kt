package tags.string

/**
 * https://www.acmicpc.net/problem/2810
 */
fun main() {
    val n = readln().toInt()
    val s = readln()
    println((s.replace("LL", "S").length + 1).coerceAtMost(n))
}
