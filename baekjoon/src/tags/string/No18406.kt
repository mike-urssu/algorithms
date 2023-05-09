package tags.string

/**
 * https://www.acmicpc.net/problem/18406
 */
fun main() {
    val n = readln()
    val s1 = n.take(n.length / 2).sumOf { it.digitToInt() }
    val s2 = n.takeLast(n.length / 2).sumOf { it.digitToInt() }
    if (s1 == s2) {
        println("LUCKY")
    } else {
        println("READY")
    }
}
