package tags.segtree

/**
 * https://www.acmicpc.net/problem/10868
 */
import java.io.BufferedWriter
import java.io.OutputStreamWriter

private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var numbers: IntArray
private lateinit var segmentTree: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    numbers = IntArray(n + 1).apply {
        IntArray(n) { readln().toInt() }.copyInto(this, 1)
    }

    segmentTree = IntArray(n * 4)
    init(1, 1, n)

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        writer.write("${min(1, 1, n, a, b)}\n")
    }
    writer.flush()
}

private fun init(node: Int, start: Int, end: Int) {
    if (start == end) {
        segmentTree[node] = numbers[start]
        return
    }

    val mid = (start + end) shr 1
    init(node * 2, start, mid)
    init(node * 2 + 1, mid + 1, end)

    segmentTree[node] = segmentTree[node * 2].coerceAtMost(segmentTree[node * 2 + 1])
}

private fun min(node: Int, start: Int, end: Int, a: Int, b: Int): Int {
    if (b < start) {
        return Int.MAX_VALUE
    }
    if (end < a) {
        return Int.MAX_VALUE
    }
    if (a <= start && end <= b) {
        return segmentTree[node]
    }

    val mid = (start + end) shr 1
    val leftMin = min(node * 2, start, mid, a, b)
    val rightMin = min(node * 2 + 1, mid + 1, end, a, b)
    return leftMin.coerceAtMost(rightMin)
}
