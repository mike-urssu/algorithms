package tags.segtree

/**
 * https://www.acmicpc.net/problem/2042
 */
private lateinit var numbers: LongArray
private lateinit var segmentTree: LongArray

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    numbers = LongArray(n + 1).apply {
        (1..n).forEach { i -> this[i] = readln().toLong() }
    }

    segmentTree = LongArray(4 * n)
    init(1, 1, n)

    repeat(m + k) {
        val (a, b, c) = readln().split(" ").map { it.toLong() }
        if (a == 1L) {
            numbers[b.toInt()] = c
            update(1, 1, n, b.toInt(), numbers[b.toInt()])
        } else {
            println(sum(1, 1, n, b.toInt()..c.toInt()))
        }
    }
}

private fun init(node: Int, from: Int, to: Int) {
    if (from == to) {
        segmentTree[node] = numbers[from]
        return
    }

    val mid = (from + to) shr 1
    init(node * 2, from, mid)
    init(node * 2 + 1, mid + 1, to)
    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1]
}

private fun update(node: Int, from: Int, to: Int, index: Int, value: Long) {
    if (index < from || index > to) {
        return
    }
    if (from == to) {
        segmentTree[node] = value
        return
    }

    val mid = (from + to) shr 1
    update(node * 2, from, mid, index, value)
    update(node * 2 + 1, mid + 1, to, index, value)
    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1]
}

private fun sum(node: Int, from: Int, to: Int, range: IntRange): Long {
    if (range.last < from || to < range.first) {
        return 0L
    }

    if (range.first <= from && to <= range.last) {
        return segmentTree[node]
    }

    val mid = (from + to) shr 1
    val left = sum(node * 2, from, mid, range)
    val right = sum(node * 2 + 1, mid + 1, to, range)
    return left + right
}
