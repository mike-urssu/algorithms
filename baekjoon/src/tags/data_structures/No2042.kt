package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2042
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var numbers: LongArray
private lateinit var tree: LongArray

fun main() {
    val (n, m, k) = reader.readLine().split(" ").map { it.toInt() }
    numbers = LongArray(n + 1)
        .apply { (1..n).forEach { i -> this[i] = reader.readLine().toLong() } }
    tree = LongArray(n * 4)

    init(1, 0, n)

    repeat(m + k) {
        val (a, b, c) = reader.readLine().split(" ").map { it.toLong() }
        if (a == 1L) {
            update(1, 0, n, b.toInt(), c)
        } else {
            writer.write("${query(1, 0, n, b.toInt(), c.toInt())}\n")
        }
    }
    writer.flush()
}

private fun init(node: Int, start: Int, end: Int) {
    if (start == end) {
        tree[node] = numbers[start]
        return
    }

    val mid = (start + end) / 2
    init(node * 2, start, mid)
    init(node * 2 + 1, mid + 1, end)
    tree[node] = tree[node * 2] + tree[node * 2 + 1]
}

private fun update(node: Int, start: Int, end: Int, index: Int, value: Long) {
    if (index < start || end < index) {
        return
    }

    if (start == end) {
        tree[node] = value
        return
    }

    val mid = (start + end) / 2
    update(node * 2, start, mid, index, value)
    update(node * 2 + 1, mid + 1, end, index, value)
    tree[node] = tree[node * 2] + tree[node * 2 + 1]
}

private fun query(node: Int, start: Int, end: Int, from: Int, to: Int): Long {
    if (to < start || end < from) {
        return 0
    }

    if (from <= start && end <= to) {
        return tree[node]
    }

    val mid = (start + end) / 2
    val leftSum = query(node * 2, start, mid, from, to)
    val rightSum = query(node * 2 + 1, mid + 1, end, from, to)
    return leftSum + rightSum
}
