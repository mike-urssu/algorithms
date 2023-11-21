package tags.segtree

/**
 * https://www.acmicpc.net/problem/2357
 */
private lateinit var numbers: IntArray
private lateinit var minSegmentTree: IntArray
private lateinit var maxSegmentTree: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    numbers = IntArray(n + 1).apply {
        (1..n).forEach { i -> this[i] = readln().toInt() }
    }

    minSegmentTree = IntArray(4 * n)
    maxSegmentTree = IntArray(4 * n)
    init(1, 1, n)

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        println("${getMin(1, 1, n, a..b)} ${getMax(1, 1, n, a..b)}")
    }
}

private fun init(node: Int, from: Int, to: Int) {
    if (from == to) {
        minSegmentTree[node] = numbers[from]
        maxSegmentTree[node] = numbers[from]
        return
    }

    val mid = (from + to) shr 1
    init(node * 2, from, mid)
    init(node * 2 + 1, mid + 1, to)
    minSegmentTree[node] = minOf(minSegmentTree[node * 2], minSegmentTree[node * 2 + 1])
    maxSegmentTree[node] = maxOf(maxSegmentTree[node * 2], maxSegmentTree[node * 2 + 1])
}

private fun getMin(node: Int, from: Int, to: Int, range: IntRange): Int {
    if (range.last < from || to < range.first) {
        return Int.MAX_VALUE
    }

    if (range.first <= from && to <= range.last) {
        return minSegmentTree[node]
    }

    val mid = (from + to) shr 1
    val left = getMin(node * 2, from, mid, range)
    val right = getMin(node * 2 + 1, mid + 1, to, range)
    return minOf(left, right)
}

private fun getMax(node: Int, from: Int, to: Int, range: IntRange): Int {
    if (range.last < from || to < range.first) {
        return Int.MIN_VALUE
    }

    if (range.first <= from && to <= range.last) {
        return maxSegmentTree[node]
    }

    val mid = (from + to) shr 1
    val left = getMax(node * 2, from, mid, range)
    val right = getMax(node * 2 + 1, mid + 1, to, range)
    return maxOf(left, right)
}
