package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2632
 */
fun main() {
    val size = readln().toInt()
    val (m, n) = readln().split(" ").map { it.toInt() }
    val pizzaA = IntArray(m) { readln().toInt() }
    val pizzaB = IntArray(n) { readln().toInt() }
    println(getCount(m, pizzaA, n, pizzaB, size))
}

private fun getCount(m: Int, pizzaA: IntArray, n: Int, pizzaB: IntArray, size: Int): Int {
    val sizesA = getSizes(m, pizzaA)
    val sizesB = getSizes(n, pizzaB)
    return sizesA.sumOf { getLowerBound(sizesB, size - it + 1) - getLowerBound(sizesB, size - it) }
}

private fun getSizes(n: Int, pizza: IntArray): List<Int> {
    val sizes = mutableListOf<Int>()
    sizes.add(0)
    sizes.add(pizza.sum())
    val prefixSum = getPrefixSum(n, pizza)
    for (i in 1 until n) {
        prefixSum[i].forEach { sizes.add(it) }
    }
    return sizes.sorted()
}

private fun getPrefixSum(n: Int, pizza: IntArray): Array<IntArray> {
    val prefixSum = Array(n) { IntArray(n) }
    for (i in 1 until n) {
        for (j in prefixSum.indices) {
            for (k in 0 until i) {
                prefixSum[i][j] += pizza[(j + k) % n]
            }
        }
    }
    return prefixSum
}

private fun getLowerBound(numbers: List<Int>, n: Int): Int {
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
