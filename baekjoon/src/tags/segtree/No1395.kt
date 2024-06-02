package tags.segtree

/**
 * https://www.acmicpc.net/problem/1395
 */
private val reader = System.`in`.bufferedReader()
private val writer = System.out.bufferedWriter()

private lateinit var tree: IntArray
private lateinit var lazyTree: IntArray

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    tree = IntArray(n * 4)
    lazyTree = IntArray(n * 4)

    repeat(m) {
        val (o, s, t) = reader.readLine().split(" ").map { it.toInt() }
        if (o == 0) {
            update(1, 1, n, s, t)
        } else {
            writer.write("${sum(1, 1, n, s, t)}\n")
        }
    }
    writer.flush()
}

private fun sum(node: Int, start: Int, end: Int, s: Int, t: Int): Int {
    lazyUpdate(node, start, end)

    if (t < start || end < s) {
        return 0
    }

    if (s <= start && end <= t) {
        return tree[node]
    }

    val mid = (start + end) shr 1
    val left = sum(node * 2, start, mid, s, t)
    val right = sum(node * 2 + 1, mid + 1, end, s, t)
    return left + right
}

private fun update(node: Int, start: Int, end: Int, s: Int, t: Int) {
    lazyUpdate(node, start, end)

    if (t < start || end < s) {
        return
    }

    if (s <= start && end <= t) {
        if (start != end) {
            tree[node] = (end - start + 1) - tree[node]
            lazyTree[node * 2]++
            lazyTree[node * 2 + 1]++
        } else {
            tree[node] = (tree[node] + 1) % 2
        }
        return
    }

    val mid = (start + end) shr 1
    update(node * 2, start, mid, s, t)
    update(node * 2 + 1, mid + 1, end, s, t)
    tree[node] = tree[node * 2] + tree[node * 2 + 1]
}

private fun lazyUpdate(node: Int, start: Int, end: Int) {
    if (lazyTree[node] % 2 == 1) {
        tree[node] = (end - start + 1) - tree[node]
        if (start != end) {
            lazyTree[node * 2]++
            lazyTree[node * 2 + 1]++
        }
        lazyTree[node] = 0
    }
}
