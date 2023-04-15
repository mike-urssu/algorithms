package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/3020
 */
fun main() {
    val (n, h) = readln().split(" ").map { it.toInt() }
    val l = mutableMapOf<Int, Int>()
    val r = mutableMapOf<Int, Int>()
    repeat(n) { i ->
        val v = readln().toInt()
        if (i % 2 == 0) {
            l[v] = (l[v] ?: 0) + 1
        } else {
            r[v] = (r[v] ?: 0) + 1
        }
    }

    val lh = IntArray(h + 1)
    lh[h] = l[h] ?: 0
    (h - 1 downTo 1).forEach { i ->
        lh[i] += lh[i + 1] + (l[i] ?: 0)
    }

    val rh = IntArray(h + 1)
    (1..h).forEach { i ->
        rh[i] += rh[i - 1] + (r[h - i + 1] ?: 0)
    }

    val heights = sortedMapOf<Int, Int>()
    (1..h).forEach { i ->
        val v = lh[i] + rh[i]
        heights[v] = (heights[v] ?: 0) + 1
    }
    val min = heights.keys.min()
    println("$min ${heights[min]}")
}
