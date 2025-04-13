package tags.implementation

/**
 * https://www.acmicpc.net/problem/18883
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    (0 until n).forEach { i ->
        println((1..m).joinToString(" ") { (it + i * m).toString() })
    }
}
