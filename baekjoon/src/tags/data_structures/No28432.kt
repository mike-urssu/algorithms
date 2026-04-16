package tags.data_structures

/**
 * https://www.acmicpc.net/problem/28432
 */
fun main() {
    val n = readln().toInt()
    val words = Array(n) { readln() }
    val m = readln().toInt()
    val candidates = Array(m) { readln() }

    val set = words.toSet()
    val index = words.indexOf("?")
    val word = if (n == 1) {
        candidates[0]
    } else if (index == 0) {
        val c = words[1][0]
        candidates.first { it !in set && it.last() == c }
    } else if (index == words.lastIndex) {
        val c = words[n - 2].last()
        candidates.first { it !in set && it[0] == c }
    } else {
        val c1 = words[index - 1].last()
        val c2 = words[index + 1][0]
        candidates.first { it !in set && it[0] == c1 && it.last() == c2 }
    }
    println(word)
}
