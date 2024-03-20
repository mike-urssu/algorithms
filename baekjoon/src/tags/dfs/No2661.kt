package tags.dfs

/**
 * https://www.acmicpc.net/problem/2661
 */
import kotlin.system.exitProcess

private lateinit var numbers: IntArray

fun main() {
    val n = readln().toInt()
    numbers = IntArray(n)
    numbers[0] = 1
    dfs(n, 1)
}

private fun dfs(n: Int, index: Int) {
    if (!isValid(index)) {
        return
    }

    if (n == index) {
        println(numbers.joinToString(""))
        exitProcess(0)
    }

    when (numbers[index - 1]) {
        1 -> {
            numbers[index] = 2
            dfs(n, index + 1)
            numbers[index] = 3
            dfs(n, index + 1)
        }

        2 -> {
            numbers[index] = 1
            dfs(n, index + 1)
            numbers[index] = 3
            dfs(n, index + 1)
        }

        3 -> {
            numbers[index] = 1
            dfs(n, index + 1)
            numbers[index] = 2
            dfs(n, index + 1)
        }
    }
}

private fun isValid(n: Int): Boolean {
    for (i in 0 until n / 2) {
        val leftIndex = n - 1 - i * 2 - 1
        val rightIndex = n - 1 - i
        if ((0..i).all { j -> numbers[leftIndex + j] == numbers[rightIndex + j] }) {
            return false
        }
    }
    return true
}
