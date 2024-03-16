package tags.trees

/**
 * https://www.acmicpc.net/problem/1991
 */
private val nodes = getNodes()

fun main() {
    printPreorderTraversal(nodes['A']!!)
    println()

    printInorderTraversal(nodes['A']!!)
    println()

    printPostorderTraversal(nodes['A']!!)
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

private fun printPreorderTraversal(node: Node) {
    print(node.name)
    node.leftChild?.let { printPreorderTraversal(node.leftChild!!) }
    node.rightChild?.let { printPreorderTraversal(node.rightChild!!) }
}

private fun printInorderTraversal(node: Node) {
    node.leftChild?.let { printInorderTraversal(node.leftChild!!) }
    print(node.name)
    node.rightChild?.let { printInorderTraversal(node.rightChild!!) }
}

private fun printPostorderTraversal(node: Node) {
    node.leftChild?.let { printPostorderTraversal(node.leftChild!!) }
    node.rightChild?.let { printPostorderTraversal(node.rightChild!!) }
    print(node.name)
}
