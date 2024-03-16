package tags.trees

/**
 * https://www.acmicpc.net/problem/2263
 */
private lateinit var inOrderTraversal: IntArray
private lateinit var postOrderTraversal: IntArray
private lateinit var preOrderTraversal: IntArray
private lateinit var indices: IntArray

fun main() {
    val n = readln().toInt()
    inOrderTraversal = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    postOrderTraversal = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    indices = getIndices(n)

    preOrderTraversal = IntArray(n + 1)
    setPreOrderTraversal(1, n, 1, n)
    println(preOrderTraversal.drop(1).joinToString(" "))
}

private fun getIndices(n: Int): IntArray {
    val indices = IntArray(n + 1)
    (1..n).forEach { i -> indices[inOrderTraversal[i]] = i }
    return indices
}

private var preOrderIndex = 1

private fun setPreOrderTraversal(inStart: Int, inEnd: Int, postStart: Int, postEnd: Int) {
    if (inStart > inEnd || postStart > postEnd) {
        return
    }

    val root = postOrderTraversal[postEnd]
    preOrderTraversal[preOrderIndex++] = root

    val inOrderRootIndex = indices[root]
    val leftSize = inOrderRootIndex - inStart

    setPreOrderTraversal(inStart, inOrderRootIndex - 1, postStart, postStart + leftSize - 1)
    setPreOrderTraversal(inOrderRootIndex + 1, inEnd, postStart + leftSize, postEnd - 1)
}
