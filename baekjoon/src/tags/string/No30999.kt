package tags.string

/**
 * https://www.acmicpc.net/problem/30999
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val count = (0 until n).count { readln().count { it == 'O' } > m / 2 }
    println(count)
}
