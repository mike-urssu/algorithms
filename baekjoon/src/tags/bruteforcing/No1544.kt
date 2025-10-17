package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1544
 */
fun main() {
    val n = readln().toInt()
    val words = mutableListOf<String>()
    repeat(n) {
        var isCycle = false
        val word = readln()
        if (words.any { isCycle(it, word) }) {
            isCycle = true
        }
        if (!isCycle) {
            words.add(word)
        }
    }

    println(words.size)
}

private fun isCycle(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) {
        return false
    }

    for (j in word1.indices) {
        if (word1.indices.all { i -> word1[i] == word2[(i + j) % word1.length] }) {
            return true
        }
    }

    return false
}
