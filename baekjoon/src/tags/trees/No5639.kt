package tags.trees

/**
 * https://www.acmicpc.net/problem/5639
 */
private lateinit var preOrderTraversal: List<Int>

fun main() {
    preOrderTraversal = getPreorderTraversal()

    val postOrderTraversal = mutableListOf<Int>()
    getPostOrderTraversal(postOrderTraversal, 0, preOrderTraversal.lastIndex)
    postOrderTraversal.forEach { println(it) }
}

private fun getPreorderTraversal(): List<Int> {
    val numbers = mutableListOf<Int>()
    while (true) {
        val n = (readlnOrNull() ?: break).toInt()
        numbers.add(n)
    }
    return numbers
}

private fun getPostOrderTraversal(postOrderTraversal: MutableList<Int>, start: Int, end: Int) {
    if (start > end) {
        return
    }

    val mid = (start + 1..end).firstOrNull { i -> preOrderTraversal[start] < preOrderTraversal[i] } ?: (end + 1)
    getPostOrderTraversal(postOrderTraversal, start + 1, mid - 1)
    getPostOrderTraversal(postOrderTraversal, mid, end)
    postOrderTraversal.add(preOrderTraversal[start])
}
