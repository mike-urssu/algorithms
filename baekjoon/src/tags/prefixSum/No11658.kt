package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/11658
 */
private lateinit var tree: Array<IntArray>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    tree = Array(n + 1) { IntArray(n + 1) }
    (1..n).forEach { i ->
        (1..n).forEach { j ->
            update(n, i, j, graph[i - 1][j - 1])
        }
    }

    repeat(m) {
        val numbers = readln().split(" ").map { it.toInt() }
        val w = numbers[0]
        if (w == 0) {
            val x = numbers[1]
            val y = numbers[2]
            val c = numbers[3]
            update(n, x, y, c - graph[x - 1][y - 1])
            graph[x - 1][y - 1] = c
        } else {
            val x1 = numbers[1]
            val y1 = numbers[2]
            val x2 = numbers[3]
            val y2 = numbers[4]
            println(sum(x2, y2) - sum(x1 - 1, y2) - sum(x2, y1 - 1) + sum(x1 - 1, y1 - 1))
        }
    }
}

private fun update(n: Int, x: Int, y: Int, value: Int) {
    var i = x
    while (i <= n) {
        var j = y
        while (j <= n) {
            tree[i][j] += value
            j += j and -j
        }
        i += i and -i
    }
}

private fun sum(x: Int, y: Int): Int {
    var sum = 0
    var i = x
    while (i > 0) {
        var j = y
        while (j > 0) {
            sum += tree[i][j]
            j -= j and -j
        }
        i -= i and -i
    }
    return sum
}
