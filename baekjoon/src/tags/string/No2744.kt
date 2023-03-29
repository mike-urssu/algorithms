package tags.string

/**
 * https://www.acmicpc.net/problem/2744
 */
fun main() {
    readln().map {
        if (it.isLowerCase()) {
            it.uppercase()
        } else {
            it.lowercase()
        }
    }.forEach { print(it) }
}
