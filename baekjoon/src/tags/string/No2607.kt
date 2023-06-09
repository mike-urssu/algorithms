package tags.string

/**
 * https://www.acmicpc.net/problem/2607
 */
fun main() {
    val n = readln().toInt()
    val s = readln()
    val words = Array(n - 1) { readln() }
    val count = words.count { word -> isSimilar(s, word) }
    println(count)
}

private fun isSimilar(s: String, word: String): Boolean {
    if (s.length - word.length !in -1..1) {
        return false
    }
    val alphabets = IntArray(26)
    s.forEach { alphabets[it - 'A']++ }
    word.forEach { alphabets[it - 'A']-- }
    return when (alphabets.count { it != 0 }) {
        0 -> true
        1 -> {
            val value = alphabets[alphabets.indexOfFirst { it != 0 }]
            value == 1 || value == -1
        }

        2 -> {
            val value1 = alphabets[alphabets.indexOfFirst { it != 0 }]
            val value2 = alphabets[alphabets.indexOfLast { it != 0 }]
            (value1 == 1 && value2 == -1) || (value1 == -1 && value2 == 1)
        }

        else -> false
    }
}
