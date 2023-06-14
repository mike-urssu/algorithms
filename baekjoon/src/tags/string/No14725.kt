package tags.string

/**
 * https://www.acmicpc.net/problem/14725
 */
fun main() {
    val n = readln().toInt()
    val trie = Trie2()
    repeat(n) {
        val words = readln().split(" ").drop(1)
        trie.insert(words)
    }
    printNodes(trie, 0)
}

private class Trie2(
    val childNodes: MutableMap<String, Trie2> = sortedMapOf(),
    var isLast: Boolean = false
) {
    fun insert(words: List<String>) {
        var node = this
        words.forEach { word ->
            node.childNodes.putIfAbsent(word, Trie2())
            node = node.childNodes[word]!!
        }
        node.isLast = true
    }
}

private fun printNodes(trie: Trie2, depth: Int) {
    trie.childNodes.forEach { (word, trie) ->
        println("${"--".repeat(depth)}$word")
        printNodes(trie, depth + 1)
    }
}
