package tags.implementation

/**
 * https://www.acmicpc.net/problem/15963
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toLong() }
    if (n == m) {
        println(1)
    } else {
        println(0)
    }
}
