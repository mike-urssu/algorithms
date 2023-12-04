package tags.segtree

/**
 * https://www.acmicpc.net/problem/1275
 */
private lateinit var numbers: LongArray
private lateinit var segmentTree: LongArray

fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    numbers = getNumbers(n)

    segmentTree = LongArray(n * 4)
    init(1, 1, n)

    repeat(q) {
        val (x, y, a, b) = readln().split(" ").map { it.toInt() }
        if (x <= y) {
            println(sum(1, 1, n, x..y))
        } else {
            println(sum(1, 1, n, y..x))
        }
        update(1, 1, n, a, b.toLong())
        numbers[a] = b.toLong()
    }
}

private fun getNumbers(n: Int): LongArray {
    val numbers = LongArray(n + 1)
    readln().split(" ").map { it.toLong() }.toLongArray().copyInto(numbers, 1)
    return numbers
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

private fun sum(node: Int, start: Int, end: Int, range: IntRange): Long {
    if (range.last < start || end < range.first) {
        return 0
    }

    if (range.first <= start && end <= range.last) {
        return segmentTree[node]
    }

    val mid = (start + end) shr 1
    val left = sum(node * 2, start, mid, range)
    val right = sum(node * 2 + 1, mid + 1, end, range)
    return left + right
}

private fun update(node: Int, start: Int, end: Int, index: Int, value: Long) {
    if (index !in start..end) {
        return
    }

    if (start == end) {
        segmentTree[node] = value
        return
    }

    val mid = (start + end) shr 1
    update(node * 2, start, mid, index, value)
    update(node * 2 + 1, mid + 1, end, index, value)
    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1]
}
