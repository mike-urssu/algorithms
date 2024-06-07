package tags.segtree

/**
 * https://www.acmicpc.net/problem/14428
 */
private lateinit var numbers: IntArray
private lateinit var tree: IntArray

fun main() {
    val n = readln().toInt()
    numbers = IntArray(n + 1).apply {
        this[0] = Int.MAX_VALUE
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    tree = IntArray(n * 4)
    init(1, 1, n)

    val m = readln().toInt()
    repeat(m) {
        val input = readln().split(" ").map { it.toInt() }
        if (input[0] == 1) {
            update(1, 1, n, input[1], input[2])
        } else {
            println(getMin(1, 1, n, input[1], input[2]))
        }
    }
}

private fun init(node: Int, start: Int, end: Int) {
    if (start == end) {
        tree[node] = start
        return
    }

    val mid = (start + end) shr 1
    init(node * 2, start, mid)
    init(node * 2 + 1, mid + 1, end)

    tree[node] = if (numbers[tree[node * 2]] <= numbers[tree[node * 2 + 1]]) {
        tree[node * 2]
    } else {
        tree[node * 2 + 1]
    }
}

private fun update(node: Int, start: Int, end: Int, i: Int, v: Int) {
    if (i < start || end < i) {
        return
    }

    if (start == end) {
        numbers[i] = v
        return
    }

    val mid = (start + end) shr 1
    update(node * 2, start, mid, i, v)
    update(node * 2 + 1, mid + 1, end, i, v)
    tree[node] = if (numbers[tree[node * 2]] <= numbers[tree[node * 2 + 1]]) {
        tree[node * 2]
    } else {
        tree[node * 2 + 1]
    }
}

private fun getMin(node: Int, start: Int, end: Int, i: Int, j: Int): Int {
    if (j < start || end < i) {
        return 0
    }

    if (i <= start && end <= j) {
        return tree[node]
    }

    val mid = (start + end) shr 1
    val left = getMin(node * 2, start, mid, i, j)
    val right = getMin(node * 2 + 1, mid + 1, end, i, j)
    return if (numbers[left] <= numbers[right]) {
        left
    } else {
        right
    }
}
