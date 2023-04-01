package tags.string

/**
 * https://www.acmicpc.net/problem/5052
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val phones = Array(n) { readln() }.sorted()
        if (isConsistent(phones)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

private fun isConsistent(phones: List<String>): Boolean {
    val trie = Trie()
    for (phone in phones) {
        if (!trie.isConsistent(phone)) {
            return false
        }
        trie.insert(phone)
    }
    return true
}

private class Trie(
    val childNodes: MutableMap<Char, Trie> = mutableMapOf(),
    var isLast: Boolean = false
) {
    fun insert(phone: String) {
        var node = this
        phone.forEach { c ->
            node.childNodes.putIfAbsent(c, Trie())
            node = node.childNodes[c]!!
        }
        node.isLast = true
    }

    fun isConsistent(phone: String): Boolean {
        var trie = this
        for (c in phone) {
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
