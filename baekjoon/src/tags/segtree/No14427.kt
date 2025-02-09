package tags.segtree

/**
 * https://www.acmicpc.net/problem/14427
 */
private val reader = System.`in`.bufferedReader()
private lateinit var numbers: IntArray
private lateinit var tree: IntArray

fun main() {
    val n = reader.readLine().toInt()
    numbers = IntArray(n + 1).apply {
        this[0] = Int.MAX_VALUE
        reader.readLine().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    tree = IntArray(n * 4)

    init(1, 1, n)

    val answer = StringBuilder()
    val m = reader.readLine().toInt()
    repeat(m) {
        val s = reader.readLine()
        when (s[0]) {
            '1' -> {
                val (_, index, v) = s.split(" ").map { it.toInt() }
                numbers[index] = v
                update(1, 1, n, index)
            }

            '2' -> {
                answer.appendLine(tree[1])
            }
        }
    }
    println(answer)
}


private fun init(node: Int, from: Int, to: Int): Int {
    if (from == to) {
        tree[node] = from
        return tree[node]
    }

    val mid = (from + to) shr 1
    val left = init(node * 2, from, mid)
    val right = init(node * 2 + 1, mid + 1, to)
    tree[node] = if (numbers[left] <= numbers[right]) {
        left
    } else {
        right
    }
    return tree[node]
}

private fun update(node: Int, from: Int, to: Int, index: Int): Int {
    if (from == to) {
        return from
    } else if (index !in from..to) {
        return tree[node]
    }

    val mid = (from + to) shr 1
    val left = update(node * 2, from, mid, index)
    val right = update(node * 2 + 1, mid + 1, to, index)
    tree[node] = if (numbers[left] <= numbers[right]) {
        left
    } else {
        right
    }
    return tree[node]
}
