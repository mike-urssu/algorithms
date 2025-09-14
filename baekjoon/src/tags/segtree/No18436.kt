package tags.segtree

/**
 * https://www.acmicpc.net/problem/18436
 */
private lateinit var numbers: IntArray
private lateinit var tree: IntArray

fun main() {
    val n = readln().toInt()
    numbers = IntArray(n + 1).apply { readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1) }
    tree = IntArray(n * 4)
    init(1, 1, n)

    val m = readln().toInt()
    repeat(m) {
        val input = readln().split(" ").map { it.toInt() }
        when (input[0]) {
            1 -> swap(1, 1, n, input[1], input[2])
            2 -> {
                val (_, l, r) = input
                println(r - l + 1 - countOdd(1, 1, n, l, r))
            }

            3 -> {
                val (_, l, r) = input
                println(countOdd(1, 1, n, l, r))
            }
        }
    }
}

private fun init(node: Int, from: Int, to: Int): Int {
    if (from == to) {
        tree[node] = numbers[from] % 2
        return tree[node]
    }

    val mid = (from + to) / 2
    val left = init(node * 2, from, mid)
    val right = init(node * 2 + 1, mid + 1, to)
    tree[node] = left + right
    return tree[node]
}

private fun swap(node: Int, from: Int, to: Int, i: Int, x: Int) {
    if (i < from || to < i) {
        return
    }

    if (from == to) {
        tree[node] = x % 2
        return
    }

    val mid = (from + to) / 2
    swap(node * 2, from, mid, i, x)
    swap(node * 2 + 1, mid + 1, to, i, x)
    tree[node] = tree[node * 2] + tree[node * 2 + 1]
}

private fun countOdd(node: Int, from: Int, to: Int, l: Int, r: Int): Int {
    if (r < from || to < l) {
        return 0
    }

    if (l <= from && to <= r) {
        return tree[node]
    }

    val mid = (from + to) / 2
    val left = countOdd(node * 2, from, mid, l, r)
    val right = countOdd(node * 2 + 1, mid + 1, to, l, r)
    return left + right
}
