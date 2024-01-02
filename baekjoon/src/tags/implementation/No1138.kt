package tags.implementation

/**
 * https://www.acmicpc.net/problem/1138
 */
import kotlin.system.exitProcess

private lateinit var numbers: IntArray
private lateinit var combination: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    val n = readln().toInt()
    numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    combination = IntArray(n)
    isVisited = BooleanArray(n + 1)

    combination(n, 0)
}

private fun combination(n: Int, index: Int) {
    if (n == index) {
        if (matches(n)) {
            println(combination.joinToString(" "))
            exitProcess(0)
        }
        return
    }

    (1..n).forEach { i ->
        if (!isVisited[i]) {
            isVisited[i] = true
            combination[index] = i
            combination(n, index + 1)
            isVisited[i] = false
        }
    }
}

private fun matches(n: Int): Boolean {
    return (1..n).all { i ->
        val index = combination.indexOf(i)
        val count = (0 until index).count { j -> combination[j] > i }
        count == numbers[i - 1]
    }
}
