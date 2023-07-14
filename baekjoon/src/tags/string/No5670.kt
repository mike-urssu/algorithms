package tags.string

/**
 * https://www.acmicpc.net/problem/5670
 */
import kotlin.math.roundToInt

fun main() {
    while (true) {
        val n = (readlnOrNull() ?: break).toInt()
        val words = Array(n) { readln() }
        val pressedCounts = getPressedCounts(n, words)
        println(String.format("%.2f", (pressedCounts.average() * 100).roundToInt() * 0.01))
    }
}

private fun getPressedCounts(n: Int, words: Array<String>): IntArray {
    val trie = getTrie(words)
    return IntArray(n) { i -> getPressedCount(words[i], trie) }
}

private fun getTrie(words: Array<String>): Trie3 {
    val trie = Trie3()
    words.forEach { trie.insert(it) }
    return trie
}

private fun getPressedCount(word: String, trie: Trie3): Int {
    var count = 1
    var node = trie.childNodes[word[0]]!!
    var index = 1
    while (index < word.length) {
        if (node.isLast && node.childNodes.isNotEmpty()) {
            count++
        } else if (node.childNodes.size > 1) {
            count++
        }
        node = node.childNodes[word[index]]!!
        index++
    }
    return count
}

private class Trie3(
    val childNodes: MutableMap<Char, Trie3> = mutableMapOf(),
    var isLast: Boolean = false
) {
    fun insert(s: String) {
        var node = this
        s.forEach {
            node.childNodes.putIfAbsent(it, Trie3())
            node = node.childNodes[it]!!
        }
        node.isLast = true
    }
}
