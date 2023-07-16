package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2529
 */
private var k = 0
private lateinit var symbols: CharArray
private lateinit var combination: IntArray
private lateinit var isVisited: BooleanArray

private var max = ""
private var min = "9999999999"

fun main() {
    k = readln().toInt()
    symbols = readln().split(" ").map { it[0] }.toCharArray()
    combination = IntArray(k + 1)
    isVisited = BooleanArray(10)
    findValidCombinations(0)
    println(max)
    println(min)
}

private fun findValidCombinations(index: Int) {
    if (index == combination.size) {
        if (isValid()) {
            val value = combination.joinToString("")
            max = max.coerceAtLeast(value)
            min = min.coerceAtMost(value)
        }
        return
    }

    (0..9).forEach { i ->
        if (!isVisited[i]) {
            combination[index] = i
            isVisited[i] = true
            findValidCombinations(index + 1)
            isVisited[i] = false
        }
    }
}

private fun isValid(): Boolean {
    for (i in 0 until k) {
        when (symbols[i]) {
            '>' -> if (combination[i] < combination[i + 1]) {
                return false
            }

            '<' -> if (combination[i] > combination[i + 1]) {
                return false
            }
        }
    }
    return true
}
