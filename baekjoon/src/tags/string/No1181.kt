package tags.string

/**
 * https://www.acmicpc.net/problem/1181
 */
fun main() {
    val n = readln().toInt()
    Array(n) { readln() }
        .distinct()
        .sortedWith { it, other ->
            if (it.length == other.length) {
                it.compareTo(other)
            } else {
                it.length - other.length
            }
        }
        .forEach { println(it) }
}
