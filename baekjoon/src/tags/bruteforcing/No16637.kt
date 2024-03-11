package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/16637
 */
private lateinit var formula: CharArray
private var max = Int.MIN_VALUE

fun main() {
    val n = readln().toInt()
    formula = readln().toCharArray()
    dfs(n, 2, formula[0].digitToInt())
    println(max)
}

private fun dfs(n: Int, index: Int, currentValue: Int) {
    if (n <= index) {
        max = max.coerceAtLeast(currentValue)
        return
    }

    run {
        val nextValue = calculate(currentValue, formula[index - 1], formula[index].digitToInt())
        dfs(n, index + 2, nextValue)
    }

    run {
        if (index + 2 < n) {
            val rightValue = calculate(formula[index].digitToInt(), formula[index + 1], formula[index + 2].digitToInt())
            val nextValue = calculate(currentValue, formula[index - 1], rightValue)
            dfs(n, index + 4, nextValue)
        }
    }
}

private fun calculate(n1: Int, operation: Char, n2: Int) =
    when (operation) {
        '+' -> n1 + n2
        '-' -> n1 - n2
        '*' -> n1 * n2
        else -> n1 / n2
    }
