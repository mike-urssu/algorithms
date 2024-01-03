package tags.implementation

/**
 * https://www.acmicpc.net/problem/2455
 */
fun main() {
    val (n1, m1) = readln().split(" ").map { it.toInt() }
    val (n2, m2) = readln().split(" ").map { it.toInt() }
    val (n3, m3) = readln().split(" ").map { it.toInt() }
    val (n4, m4) = readln().split(" ").map { it.toInt() }

    var people = 0
    var max = 0

    people += -n1 + m1
    max = max.coerceAtLeast(people)
    people += -n2 + m2
    max = max.coerceAtLeast(people)
    people += -n3 + m3
    max = max.coerceAtLeast(people)
    people += -n4 + m4
    max = max.coerceAtLeast(people)
    println(max)
}
