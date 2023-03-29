package tags.string

import java.util.SortedSet

/**
 * https://www.acmicpc.net/problem/7490
 */
private lateinit var formula: SortedSet<String>

fun main() {
    val t = readln().toInt()
    repeat(t) {
        formula = sortedSetOf<String>()
        val n = readln().toInt()
        val numbers = IntArray(n) { it + 1 }
        val operations = CharArray(n - 1)
        combination(numbers, operations, n - 1, 0, '+')
        combination(numbers, operations, n - 1, 0, '-')
        combination(numbers, operations, n - 1, 0, ' ')

        formula.forEach { println(it) }
        println()
    }
}

private fun combination(numbers: IntArray, operations: CharArray, n: Int, index: Int, operation: Char) {
    if (n == index) {
        val f = getFormula(numbers, operations, n)
        if (calculate(f.replace(" ", "")) == 0) {
            formula.add(f)
        }
        return
    }

    operations[index] = operation
    combination(numbers, operations, n, index + 1, '+')
    combination(numbers, operations, n, index + 1, '-')
    combination(numbers, operations, n, index + 1, ' ')
}

private fun getFormula(numbers: IntArray, operations: CharArray, n: Int): String {
    val line = StringBuilder()
    line.append(numbers.first())
    for (i in 0 until n) {
        line.append(operations[i])
        line.append(numbers[i + 1])
    }
    return line.toString()
}

private fun calculate(formula: String): Int {
    val numbers = formula.split("+", "-").map { it.toInt() }
    var index = 0
    var value = numbers[index++]
    for (i in formula.indices) {
        when (formula[i]) {
            '+' -> {
                value += numbers[index++]
            }

            '-' -> {
                value -= numbers[index++]
            }
        }
    }
    return value
}
