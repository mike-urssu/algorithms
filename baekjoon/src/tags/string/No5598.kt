package tags.string

/**
 * https://www.acmicpc.net/problem/5598
 */
fun main() {
    readln()
        .map { Char((it.code % 'A'.code + 23) % 26 + 'A'.code) }
        .forEach { print(it) }
}
