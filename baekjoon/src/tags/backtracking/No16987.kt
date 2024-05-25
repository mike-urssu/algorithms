package tags.backtracking

/**
 * https://www.acmicpc.net/problem/16987
 */
private lateinit var durabilities: IntArray
private lateinit var weights: IntArray

private var max = 0

fun main() {
    val n = readln().toInt()
    durabilities = IntArray(n)
    weights = IntArray(n)

    (0 until n).forEach { i ->
        val (s, w) = readln().split(" ").map { it.toInt() }
        durabilities[i] = s
        weights[i] = w
    }

    breakEggs(n, 0)

    println(max)
}

private fun breakEggs(n: Int, src: Int) {
    if (n == src) {
        return
    }

    if (durabilities[src] <= 0) {
        breakEggs(n, src + 1)
        return
    }

    for (j in 0 until n) {
        if (src == j) {
            continue
        }

        if (durabilities[j] > 0) {
            durabilities[src] -= weights[j]
            durabilities[j] -= weights[src]
            max = max.coerceAtLeast(durabilities.count { it <= 0 })
            breakEggs(n, src + 1)
            durabilities[src] += weights[j]
            durabilities[j] += weights[src]
        }
    }
}
