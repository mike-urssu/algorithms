package tags.data_structures

/**
 * https://www.acmicpc.net/problem/5052
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val numbers = Array(n) { readln() }.sortedArray()
        if (isConsistent(numbers)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

private fun isConsistent(numbers: Array<String>): Boolean {
    val trie = Trie()
    for (number in numbers) {
        if (trie.isConsistent(number)) {
            trie.insert(number)
        } else {
            return false
        }
    }
    return true
}

private class Trie(
    val childNodes: MutableMap<Char, Trie> = mutableMapOf(),
    var isLast: Boolean = false
) {
    fun insert(s: String) {
        var trie = this
        s.forEach { c ->
            trie.childNodes.putIfAbsent(c, Trie())
            trie = trie.childNodes[c]!!
        }
        trie.isLast = true
    }

    fun isConsistent(s: String): Boolean {
        var trie = this
        for (c in s) {
            if (trie.childNodes.contains(c)) {
                if (trie.childNodes[c]!!.isLast) {
                    return false
                } else {
                    trie = trie.childNodes[c]!!
                }
            } else {
                break
            }
        }
        return true
    }
}
