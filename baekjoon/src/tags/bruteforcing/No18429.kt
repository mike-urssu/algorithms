package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/18429
 */
private var n = 0
private var k = 0
private lateinit var weights: IntArray
private lateinit var combination: IntArray
private lateinit var isVisited: BooleanArray
private var count = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    k = input[1]
    weights = readln().split(" ").map { it.toInt() }.toIntArray()

    combination = IntArray(n)
    isVisited = BooleanArray(n)

    (0 until n).forEach { i ->
        combination[0] = weights[i]
        isVisited[i] = true
        combination(1)
        isVisited[i] = false
    }

    println(count)
}

private fun combination(r: Int) {
    if (n == r) {
        if (isValid()) {
            count++
        }
        return
    }

    (0 until n).forEach { i ->
        if (!isVisited[i]) {
            combination[r] = weights[i]
            isVisited[i] = true
            combination(r + 1)
            isVisited[i] = false
        }
    }
}

private fun isValid(): Boolean {
    val prefixSum = combination.runningFold(0, Int::plus)
    return (1..n).all { i -> prefixSum[i] - i * k >= 0 }
}
