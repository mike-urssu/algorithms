package tags.string

/**
 * https://www.acmicpc.net/problem/11656
 */
fun main() {
    val s = readln()
    s.indices
        .map { s.substring(it) }
        .sorted()
        .forEach { println(it) }
}
