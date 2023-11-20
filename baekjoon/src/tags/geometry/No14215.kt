package tags.geometry

/**
 * https://www.acmicpc.net/problem/14215
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }.sorted()
    if (a + b <= c) {
        println((a + b) * 2 - 1)
    } else {
        println(a + b + c)
    }
}
