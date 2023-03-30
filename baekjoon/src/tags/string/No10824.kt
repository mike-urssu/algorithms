package tags.string

/**
 * https://www.acmicpc.net/problem/10824
 */
fun main() {
    val (a, b, c, d) = readln().split(" ")
    println("${(a + b).toLong() + (c + d).toLong()}")
}
