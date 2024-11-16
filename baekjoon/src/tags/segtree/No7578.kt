package tags.segtree

/**
 * https://www.acmicpc.net/problem/7578
 */
private lateinit var segmentTree: LongArray

fun main() {
    val n = readln().toInt()
    val arrayA = readln().split(" ").map { it.toInt() }.toIntArray()
    val arrayB = readln().split(" ").map { it.toInt() }.toIntArray()
    segmentTree = LongArray(n * 4)

    val indices = getIndices(n, arrayA, arrayB)
    var sum = 0L
    indices.forEach { i ->
        sum += sum(1, 1, n, i + 1, n)
        update(1, 1, n, i)
    }
    println(sum)
}

private fun getIndices(n: Int, arrayA: IntArray, arrayB: IntArray): IntArray {
    val indices = mutableMapOf<Int, Int>()
    arrayB.forEachIndexed { i, v -> indices[v] = i + 1 }
    return IntArray(n) { i -> indices[arrayA[i]]!! }
}

private fun sum(node: Int, start: Int, end: Int, from: Int, to: Int): Long {
    if (to < start || end < from) {
        return 0L
    }

    if (from <= start && end <= to) {
        return segmentTree[node]
    }

    val mid = (start + end) shr 1
    val left = sum(node * 2, start, mid, from, to)
    val right = sum(node * 2 + 1, mid + 1, end, from, to)
    return left + right
}

private fun update(node: Int, start: Int, end: Int, index: Int) {
    if (index !in start..end) {
        return
    }

    if (start == end) {
        segmentTree[node] = 1
        return
    }

    val mid = (start + end) shr 1
    update(node * 2, start, mid, index)
    update(node * 2 + 1, mid + 1, end, index)
    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1]
}
