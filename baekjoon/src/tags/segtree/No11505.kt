package tags.segtree

/**
 * https://www.acmicpc.net/problem/11505
 */
private lateinit var numbers: IntArray
private lateinit var segmentTree: LongArray

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    numbers = IntArray(n + 1).apply {
        (1..n).forEach { i -> this[i] = readln().toInt() }
    }

    segmentTree = LongArray(n * 4)
    init(1, 1, n)

    repeat(m + k) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (a == 1) {
            numbers[b - 1] = c
            swap(1, 1, n, b, c.toLong())
        } else {
            println(getMul(1, 1, n, b, c))
        }
    }
}

private fun init(index: Int, from: Int, to: Int) {
    if (from == to) {
        segmentTree[index] = numbers[from].toLong()
        return
    }

    val mid = (from + to) shr 1
    init(index * 2, from, mid)
    init(index * 2 + 1, mid + 1, to)
    segmentTree[index] = (segmentTree[index * 2] * segmentTree[index * 2 + 1]) % 1000000007
}

private fun swap(index: Int, from: Int, to: Int, b: Int, c: Long) {
    if (b < from || b > to) {
        return
    }

    if (from == to) {
        segmentTree[index] = c
        return
    }

    val mid = (from + to) shr 1
    if (b in from..mid) {
        swap(index * 2, from, mid, b, c)
    }
    if (b in mid + 1..to) {
        swap(index * 2 + 1, mid + 1, to, b, c)
    }
    segmentTree[index] = (segmentTree[index * 2] * segmentTree[index * 2 + 1]) % 1000000007
}

private fun getMul(index: Int, from: Int, to: Int, b: Int, c: Int): Long {
    if (b > to || c < from) {
        return 1
    }
    if (b <= from && to <= c) {
        return segmentTree[index]
    }

    val mid = (from + to) shr 1
    val left = getMul(index * 2, from, mid, b, c)
    val right = getMul(index * 2 + 1, mid + 1, to, b, c)
    return (left * right) % 1000000007
}
