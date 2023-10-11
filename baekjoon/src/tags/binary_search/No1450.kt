package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1450
 */
fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val weights = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    println(countCombinations(n, weights, c))
}

private fun countCombinations(n: Int, weights: IntArray, c: Int): Long {
    val w1 = weights.dropLast(n / 2)
    val w2 = weights.drop((n + 1) / 2)

    val leftSums = getSums(w1.size, w1)
    val rightSums = getSums(w2.size, w2)

    return leftSums.sumOf { sum -> getLowerBound(rightSums, c - sum + 1).toLong() }
}

private fun getSums(n: Int, weights: List<Int>): List<Long> {
    val sums = mutableListOf(0L)
    for (i in 1..n) {
        val combination = IntArray(i)
        for (j in weights.indices) {
            combination(sums, weights, combination, n, i, 0, j)
        }
    }
    return sums.sorted()
}

private fun combination(
    sums: MutableList<Long>,
    weights: List<Int>,
    combination: IntArray,
    n: Int,
    r: Int,
    index: Int,
    value: Int
) {
    combination[index] = value
    if (index == r - 1) {
        sums.add(combination.sumOf { i -> weights[i].toLong() })
        return
    }

    for (i in value + 1 until n) {
        combination(sums, weights, combination, n, r, index + 1, i)
    }
}

private fun getLowerBound(numbers: List<Long>, n: Long): Int {
    var low = -1
    var high = numbers.size
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (numbers[mid] >= n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
