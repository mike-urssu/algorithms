package week6.trie

class TrieNode(
    private val childNode: MutableMap<Char, TrieNode> = mutableMapOf(),
    private var isEnded: Boolean = false
) {
    fun insert(word: String) {
        var trieNode = this

        for (character in word) {
            trieNode.childNode.putIfAbsent(character, TrieNode())
            trieNode = trieNode.childNode[character]!!
        }

        trieNode.isEnded = true
    }

    fun startsWith(word: String): Boolean {
        var trieNode = this

        for (character in word) {
            if (!trieNode.childNode.containsKey(character))
                return false
            trieNode = trieNode.childNode[character]!!
        }

        return true
    }

    fun contains(word: String): Boolean {
        var trieNode = this

        for (character in word) {
            val childNode = trieNode.childNode[character] ?: return false
            trieNode = childNode
        }

        return trieNode.isEnded
    }
}