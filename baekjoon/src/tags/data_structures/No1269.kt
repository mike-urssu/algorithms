package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1269
 */
fun main() {
    val (n1, n2) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }
    val c = mutableSetOf<Int>()
    c.addAll(a)
    c.addAll(b)
    println(c.size * 2 - n1 - n2)
}
