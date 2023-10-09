package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2243
 */
private val segmentTree = IntArray(4 * 1000000)

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val input = readln().split(" ").map { it.toInt() }
        when (input[0]) {
            1 -> {
                val b = input[1]
                popCandy(1, 1, 1000000, b)
            }

            2 -> {
                val b = input[1]
                val c = input[2]
                addCandies(1, 1, 1000000, b, c)
            }
        }
    }
}

private fun popCandy(node: Int, from: Int, to: Int, b: Int) {
    if (from == to) {
        println(from)
        segmentTree[node]--
        return
    }

    val mid = (from + to) shr 1
    if (segmentTree[node * 2] >= b) {
        popCandy(node * 2, from, mid, b)
    } else {
        popCandy(node * 2 + 1, mid + 1, to, b - segmentTree[node * 2])
    }
    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1]
}

private fun addCandies(node: Int, from: Int, to: Int, index: Int, candies: Int) {
    if (index < from || index > to) {
        return
    }

    if (from == to) {
        segmentTree[node] += candies
        return
    }

    val mid = (from + to) shr 1
    if (index <= mid) {
        addCandies(node * 2, from, mid, index, candies)
    } else if (index >= mid + 1) {
        addCandies(node * 2 + 1, mid + 1, to, index, candies)
    }
    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1]
}
