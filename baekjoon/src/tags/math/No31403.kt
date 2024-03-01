package tags.math

/**
 * https://www.acmicpc.net/problem/31403
 */
fun main() {
    val a = readln()
    val b = readln()
    val c = readln()
    println(a.toInt() + b.toInt() - c.toInt())
    println((a + b).toInt() - c.toInt())
}
