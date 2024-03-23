package tags.segtree

/**
 * https://www.acmicpc.net/problem/2268
 */
private val reader = System.`in`.bufferedReader()
private val writer = System.out.bufferedWriter()

private lateinit var tree: LongArray

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    tree = LongArray(n * 4)

    repeat(m) {
        val (order, n1, n2) = reader.readLine().split(" ").map { it.toInt() }
        if (order == 0) {
            writer.write("${sum(1, 1, n, minOf(n1, n2), maxOf(n1, n2))}\n")
        } else {
            modify(1, 1, n, n1, n2)
        }
    }
    writer.flush()
}

private fun sum(node: Int, from: Int, to: Int, i: Int, j: Int): Long {
    if (to < i || j < from) {
        return 0L
    }

    if (i <= from && to <= j) {
        return tree[node]
    }

    val mid = (from + to) shr 1
    val leftSum = sum(node * 2, from, mid, i, j)
    val rightSum = sum(node * 2 + 1, mid + 1, to, i, j)
    return leftSum + rightSum
}

private fun modify(node: Int, from: Int, to: Int, i: Int, k: Int) {
    if (i < from || to < i) {
        return
    }

    if (from == to) {
        tree[node] = k.toLong()
        return
    }

    val mid = (from + to) shr 1
    modify(node * 2, from, mid, i, k)
    modify(node * 2 + 1, mid + 1, to, i, k)
    tree[node] = tree[node * 2] + tree[node * 2 + 1]
}
