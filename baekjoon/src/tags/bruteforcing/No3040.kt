package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/3040
 */
fun main() {
    val numbers = IntArray(9) { readln().toInt() }
    val invalidIndices = getInvalidIndices(numbers, numbers.sum())

    numbers.onEachIndexed { index, number ->
        if (!invalidIndices.contains(index)) {
            println(number)
        }
    }
}

private fun getInvalidIndices(numbers: IntArray, sum: Int): IntArray {
    val invalidIndices = IntArray(2)
    for (i in 0 until numbers.size - 1) {
        for (j in i + 1 until numbers.size) {
            if (sum - numbers[i] - numbers[j] == 100) {
                invalidIndices[0] = i
                invalidIndices[1] = j
            }
        }
    }
    return invalidIndices
}
