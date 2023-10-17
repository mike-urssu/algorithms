package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1572
 */
private lateinit var numbers: IntArray
private const val MAX = 65536
private val segmentTree = IntArray(MAX * 4)

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    numbers = IntArray(n) { readln().toInt() }

    for (i in 0 until k - 1) {
        update(1, 0, MAX, numbers[i], 1)
    }

    var sum = 0L
    for (i in k - 1 until n) {
        update(1, 0, MAX, numbers[i], 1)
        sum += query(1, 0, MAX, (k + 1) / 2)
        update(1, 0, MAX, numbers[i - (k - 1)], -1)
    }
    println(sum)
}

private fun update(node: Int, start: Int, end: Int, index: Int, d: Int): Int {
    if (index < start || end < index) {
        return segmentTree[node]
    }

    if (start == end) {
        segmentTree[node] += d
        return segmentTree[node]
    }

    val mid = (start + end) shr 1
    val leftSum = update(node * 2, start, mid, index, d)
    val rightSum = update(node * 2 + 1, mid + 1, end, index, d)
    segmentTree[node] = leftSum + rightSum
    return segmentTree[node]
}

private fun query(node: Int, start: Int, end: Int, k: Int): Int {
    if (start == end) {
        return start
    }

    val mid = (start + end) shr 1
    val leftSum = segmentTree[node * 2]
    return if (leftSum >= k) {
        query(node * 2, start, mid, k)
    } else {
        query(node * 2 + 1, mid + 1, end, k - leftSum)
    }
}
