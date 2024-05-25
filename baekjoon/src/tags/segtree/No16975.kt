package tags.segtree

/**
 * https://www.acmicpc.net/problem/16975
 */
private lateinit var numbers: LongArray
private lateinit var segmentTree: LongArray
private lateinit var lazyTree: LongArray

fun main() {
    val n = readln().toInt()
    numbers = LongArray(n + 1).apply {
        readln().split(" ").map { it.toLong() }.toLongArray().copyInto(this, 1)
    }
    segmentTree = LongArray(n * 4)
    lazyTree = LongArray(n * 4)

    init(1, 1, n)

    val m = readln().toInt()
    repeat(m) {
        val input = readln().split(" ").map { it.toInt() }
        if (input[0] == 1) {
            val (i, j, k) = input.takeLast(3)
            updateRange(1, 1, n, i, j, k.toLong())
        } else {
            val x = input[1]
            println(get(1, 1, n, x))
        }
    }
}

private fun init(node: Int, start: Int, end: Int) {
    if (start == end) {
        segmentTree[node] = numbers[start]
        return
    }

    val mid = (start + end) shr 1
    init(node * 2, start, mid)
    init(node * 2 + 1, mid + 1, end)
    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1]
}

private fun updateRange(node: Int, start: Int, end: Int, i: Int, j: Int, k: Long) {
    if (j < start || end < i) {
        return
    }

    if (i <= start && end <= j) {
        segmentTree[node] += (end - start + 1) * k
        if (start != end) {
            lazyTree[node * 2] += k
            lazyTree[node * 2 + 1] += k
        }
        return
    }

    val mid = (start + end) shr 1
    updateRange(node * 2, start, mid, i, j, k)
    updateRange(node * 2 + 1, mid + 1, end, i, j, k)
    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1]
}

private fun get(node: Int, start: Int, end: Int, x: Int): Long {
    lazyUpdate(node, start, end)
    if (x < start || end < x) {
        return 0L
    }

    if (start == end) {
        return segmentTree[node]
    }

    val mid = (start + end) shr 1
    return if (x in start..mid) {
        get(node * 2, start, mid, x)
    } else {
        get(node * 2 + 1, mid + 1, end, x)
    }
}

private fun lazyUpdate(node: Int, start: Int, end: Int) {
    if (lazyTree[node] != 0L) {
        segmentTree[node] += (end - start + 1) * lazyTree[node]
        if (start != end) {
            lazyTree[node * 2] += lazyTree[node]
            lazyTree[node * 2 + 1] += lazyTree[node]
        }
        lazyTree[node] = 0L
    }
}
