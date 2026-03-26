package tags.string

/**
 * https://www.acmicpc.net/problem/12780
 */
fun main() {
    val h = readln()
    val n = readln()
    val count = h.windowed(n.length).count { it == n }
    println(count)
}
