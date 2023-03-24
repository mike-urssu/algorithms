package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/14888
 */
private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE

private lateinit var numbers: List<Int>
private lateinit var operations: CharArray
private lateinit var isVisited: BooleanArray

fun main() {
    readln().toInt()
    numbers = readln().split(" ").map { it.toInt() }
    val numberOfEachCharacter = readln().split(" ").map { it.toInt() }

    val n = numberOfEachCharacter.sum()
    val arithmeticOperations = getArithmeticOperations(numberOfEachCharacter)
    operations = CharArray(n)
    isVisited = BooleanArray(n)
    permutation(arithmeticOperations, n, 0)

    println(max)
    println(min)
}

private fun getArithmeticOperations(numbers: List<Int>): CharArray {
    val operations = StringBuilder()
    operations.append("+".repeat(numbers[0]))
    operations.append("-".repeat(numbers[1]))
    operations.append("*".repeat(numbers[2]))
    operations.append("/".repeat(numbers[3]))
    return operations.toString().toCharArray()
}

private fun permutation(arithmeticOperations: CharArray, n: Int, index: Int) {
    if (index == n) {
        val value = calculate(numbers, operations)
        max = max.coerceAtLeast(value)
        min = min.coerceAtMost(value)
        return
    }

    for (i in isVisited.indices) {
        if (!isVisited[i]) {
            operations[index] = arithmeticOperations[i]
            isVisited[i] = true
            permutation(arithmeticOperations, n, index + 1)
            isVisited[i] = false
        }
    }
}

private fun calculate(numbers: List<Int>, operations: CharArray): Int {
    var value = numbers[0]
    operations.forEachIndexed { i, operation ->
        when (operation) {
            '+' -> value += numbers[i + 1]
            '-' -> value -= numbers[i + 1]
            '*' -> value *= numbers[i + 1]
            '/' -> value /= numbers[i + 1]
        }
    }
    return value
}
