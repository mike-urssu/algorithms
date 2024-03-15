package tags.tree

/**
 * https://www.acmicpc.net/problem/2250
 */
private lateinit var tree: Array<Pair<Int, Int>>
private val nodes = mutableListOf<Triple<Int, Int, Int>>()
private lateinit var left: IntArray
private lateinit var right: IntArray

fun main() {
    val n = readln().toInt()
    tree = Array(n + 1) { -1 to -1 }
    repeat(n) {
        val (mid, left, right) = readln().split(" ").map { it.toInt() }
        nodes.add(Triple(mid, left, right))
        tree[mid] = left to right
    }

    val root = findRoot(n)

    left = IntArray(n + 1) { Int.MAX_VALUE }
    right = IntArray(n + 1)
    dfs(root, 1)

    var width = 0
    var height = 0
    (1..n).forEach { depth ->
        if (width < right[depth] - left[depth] + 1) {
            height = depth
            width = right[depth] - left[depth] + 1
        }
    }
    println("$height $width")
}

private fun findRoot(n: Int): Int {
    val counts = IntArray(n + 1)
    nodes.forEach { (mid, left, right) ->
        counts[mid]++
        if (left != -1) {
            counts[left]++
        }
        if (right != -1) {
            counts[right]++
        }
    }
    return counts.indexOf(1)
}

private var index = 1

private fun dfs(node: Int, depth: Int) {
    if (tree[node].first != -1) {
        dfs(tree[node].first, depth + 1)
    }

    left[depth] = left[depth].coerceAtMost(index)
    right[depth] = right[depth].coerceAtLeast(index)
    index++

    if (tree[node].second != -1) {
        dfs(tree[node].second, depth + 1)
    }
}
