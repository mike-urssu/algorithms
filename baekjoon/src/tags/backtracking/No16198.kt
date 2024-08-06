package tags.backtracking

/**
 * https://www.acmicpc.net/problem/16198
 */
private var n = 0
private lateinit var weights: List<Int>

private lateinit var orders: IntArray
private lateinit var isVisited: BooleanArray

private var max = 0L

fun main() {
    n = readln().toInt()
    weights = readln().split(" ").map { it.toInt() }

    orders = IntArray(n - 2)
    isVisited = BooleanArray(n).apply {
        this[0] = true
        this[n - 1] = true
    }
    accumulateEnergy(0)

    println(max)
}

private fun accumulateEnergy(index: Int) {
    if (index == n - 2) {
        calculate()
        return
    }

    (1 until n - 1).forEach { i ->
        if (!isVisited[i]) {
            isVisited[i] = true
            orders[index] = i
            accumulateEnergy(index + 1)
            isVisited[i] = false
        }
    }
}

private fun calculate() {
    var sum = 0L
    val isVisited = BooleanArray(n)
    orders.forEach { mid ->
        val left = (mid - 1 downTo 0).first { !isVisited[it] }
        val right = (mid + 1 until n).first { !isVisited[it] }
        sum += weights[left] * weights[right]
        isVisited[mid] = true
    }
    max = max.coerceAtLeast(sum)
}
