package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2303
 */
fun main() {
    val n = readln().toInt()
    var maxIndex = 0
    var max = Int.MIN_VALUE

    repeat(n) {
        val numbers = readln().split(" ").map { it.toInt() }
        val sum = getSum(numbers)
        if (max <= sum) {
            maxIndex = it + 1
            max = sum
        }
    }

    println(maxIndex)
}

private fun getSum(numbers: List<Int>): Int {
    var max = Int.MIN_VALUE
    for (i in 0 until 3) {
        for (j in i + 1 until 4) {
            for (k in j + 1 until 5) {
                max = max.coerceAtLeast((numbers[i] + numbers[j] + numbers[k]) % 10)
            }
        }
    }
    return max
}
