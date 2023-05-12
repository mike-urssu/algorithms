package tags.tree

/**
 * https://www.acmicpc.net/problem/1991
 */
private val nodes = getNodes()

fun main() {
    printPreorderTraversal('A')
    println()

    printInorderTraversal('A')
    println()

    printPostorderTraversal('A')
    println()
}

private class Node(
    val name: Char,
    var leftChild: Node? = null,
    var rightChild: Node? = null
)

private fun getNodes(): Map<Char, Node> {
    val nodes = mutableMapOf<Char, Node>()
    ('A'..'Z').forEach { nodes[it] = Node(it) }
    val n = readln().toInt()
    repeat(n) {
        val (name, leftChild, rightChild) = readln().split(" ").map { it[0] }
        if (leftChild != '.') {
            nodes[name]!!.leftChild = nodes[leftChild]
        }
        if (rightChild != '.') {
            nodes[name]!!.rightChild = nodes[rightChild]
        }
    }
    return nodes
}

private fun printPreorderTraversal(name: Char) {
    print(name)
    if (nodes[name]?.leftChild != null) {
        printPreorderTraversal(nodes[name]!!.leftChild!!.name)
    }
    if (nodes[name]?.rightChild != null) {
        printPreorderTraversal(nodes[name]!!.rightChild!!.name)
    }
}

private fun printInorderTraversal(name: Char) {
    if (nodes[name]?.leftChild != null) {
        printInorderTraversal(nodes[name]!!.leftChild!!.name)
    }
    print(name)
    if (nodes[name]?.rightChild != null) {
        printInorderTraversal(nodes[name]!!.rightChild!!.name)
    }
}

private fun printPostorderTraversal(name: Char) {
    if (nodes[name]?.leftChild != null) {
        printPostorderTraversal(nodes[name]!!.leftChild!!.name)
    }
    if (nodes[name]?.rightChild != null) {
        printPostorderTraversal(nodes[name]!!.rightChild!!.name)
    }
    print(name)
}
