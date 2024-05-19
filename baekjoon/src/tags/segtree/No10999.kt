package tags.segtree

/**
 * https://www.acmicpc.net/problem/10999
 */
private lateinit var numbers: LongArray
private lateinit var segmentTree: LongArray
private lateinit var lazy: LongArray

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    numbers = LongArray(n + 1).apply { (1..n).forEach { this[it] = readln().toLong() } }
    segmentTree = LongArray(n * 4)
    lazy = LongArray(n * 4)

    init(1, 1, n)

    repeat(m + k) {
        val input = readln().split(" ").map { it.toLong() }
        val (a, b, c) = input.take(3).map { it.toInt() }
        if (a == 1) {
            val d = input[3]
            updateRange(1, 1, n, b, c, d)
        } else {
            println(sum(1, 1, n, b, c))
        }
    }
}

private fun init(node: Int, from: Int, to: Int): Long {
    if (from == to) {
        segmentTree[node] = numbers[from]
        return segmentTree[node]
    }

    val mid = (from + to) shr 1
    val left = init(node * 2, from, mid)
    val right = init(node * 2 + 1, mid + 1, to)
    segmentTree[node] = left + right
    return segmentTree[node]
}

private fun updateRange(node: Int, from: Int, to: Int, b: Int, c: Int, d: Long) {
    updateLazy(node, from, to)

    if (c < from || to < b) {
        return
    }

    if (b <= from && to <= c) {
        segmentTree[node] += (to - from + 1) * d
        if (from != to) {
            lazy[node * 2] += d
            lazy[node * 2 + 1] += d
        }
        return
    }

    val mid = (from + to) shr 1
    updateRange(node * 2, from, mid, b, c, d)
    updateRange(node * 2 + 1, mid + 1, to, b, c, d)
    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1]
}

private fun sum(node: Int, from: Int, to: Int, b: Int, c: Int): Long {
    updateLazy(node, from, to)
    if (c < from || to < b) {
        return 0L
    }

    if (b <= from && to <= c) {
        return segmentTree[node]
    }

    val mid = (from + to) shr 1
    val left = sum(node * 2, from, mid, b, c)
    val right = sum(node * 2 + 1, mid + 1, to, b, c)
    return left + right
}

private fun updateLazy(node: Int, from: Int, to: Int) {
    if (lazy[node] != 0L) {
        segmentTree[node] += (to - from + 1) * lazy[node]
        if (from != to) {
            lazy[node * 2] += lazy[node]
            lazy[node * 2 + 1] += lazy[node]
        }
        lazy[node] = 0L
    }
}
