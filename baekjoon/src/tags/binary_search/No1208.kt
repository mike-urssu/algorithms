package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1208
 */
fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.sorted().toIntArray()

    val subSequence1 = numbers.dropLast((n + 1) / 2)
    val casesOfSum1 = getCasesOfSum(subSequence1.size, subSequence1)

    val subSequence2 = numbers.drop(n / 2)
    val casesOfSum2 = getCasesOfSum(subSequence2.size, subSequence2)

    println(countSubSequences(casesOfSum1, casesOfSum2, s))
}

private lateinit var combination: IntArray
private fun getCasesOfSum(n: Int, numbers: List<Int>): List<Int> {
    val cases = mutableListOf<Int>()
    for (r in 1..n) {
        combination = IntArray(r)
        for (i in 0 until n) {
            combination(cases, numbers, n, r, 0, i)
        }
    }
    return cases.sorted()
}

private fun combination(cases: MutableList<Int>, numbers: List<Int>, n: Int, r: Int, index: Int, value: Int) {
    combination[index] = value
    if (index == r - 1) {
        cases.add(combination.sumOf { numbers[it] })
        return
    }
    for (i in value + 1 until n) {
        combination(cases, numbers, n, r, index + 1, i)
    }
}

private fun countSubSequences(cases1: List<Int>, cases2: List<Int>, s: Int): Long {
    var count = 0L
    count += getLowerBound(cases1, s + 1) - getLowerBound(cases1, s)
    count += getLowerBound(cases2, s + 1) - getLowerBound(cases2, s)
    count += cases1.sumOf { n1 ->
        val upperBound = getLowerBound(cases2, s - n1 + 1)
        val lowerBound = getLowerBound(cases2, s - n1)
        (upperBound - lowerBound).toLong()
    }
    return count
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
