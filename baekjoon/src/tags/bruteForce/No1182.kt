package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1182
 */
private var count = 0
fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }
    (1..n).forEach { r ->
        val combination = IntArray(r)
        combination(numbers, combination, n, r, s, 0, 0)
    }
    println(count)
}

private fun combination(
    numbers: List<Int>,
    combination: IntArray,
    n: Int,
    r: Int,
    s: Int,
    i: Int,
    index: Int
) {
    if (index == r) {
        if (combination.sum() == s) {
            count++
        }
        return
    }

    if (i >= n) {
        return
    }

    combination[index] = numbers[i]
    combination(numbers, combination, n, r, s, i + 1, index + 1)
    combination(numbers, combination, n, r, s, i + 1, index)
}
