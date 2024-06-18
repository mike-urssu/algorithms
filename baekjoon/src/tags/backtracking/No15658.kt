package tags.backtracking

/**
 * https://www.acmicpc.net/problem/15658
 */
private lateinit var numbers: IntArray
private lateinit var operations: IntArray

private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE

fun main() {
    val n = readln().toInt()
    numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    operations = readln().split(" ").map { it.toInt() }.toIntArray()

    calculate(n, 1, numbers[0])

    println(max)
    println(min)
}

private fun calculate(n: Int, index: Int, value: Int) {
    if (index == n) {
        max = max.coerceAtLeast(value)
        min = min.coerceAtMost(value)
        return
    }

    for (i in 0 until 4) {
        if (operations[i] != 0) {
            operations[i]--
            val nextValue = when (i) {
                0 -> value + numbers[index]
                1 -> value - numbers[index]
                2 -> value * numbers[index]
                else -> {
                    if (value >= 0) {
                        value / numbers[index]
                    } else {
                        -(-value / numbers[index])
                    }
                }
            }
            calculate(n, index + 1, nextValue)
            operations[i]++
        }
    }
}
