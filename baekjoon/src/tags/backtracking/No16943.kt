package tags.backtracking

/**
 * https://www.acmicpc.net/problem/16943
 */
private lateinit var digits: IntArray
private lateinit var combination: IntArray
private lateinit var isVisited: BooleanArray
private var c = Int.MIN_VALUE

fun main() {
    val (a, b) = readln().split(" ")
    digits = a.toCharArray().map { it.digitToInt() }.toIntArray()
    combination = IntArray(digits.size)
    isVisited = BooleanArray(digits.size)

    a.indices.forEach { i ->
        if (digits[i] != 0) {
            combination[0] = digits[i]
            isVisited[i] = true
            combination(1, digits[i], b.toInt())
            isVisited[i] = false
        }
    }

    c = c.coerceAtLeast(-1)
    println(c)
}

private fun combination(index: Int, v: Int, b: Int) {
    if (v > b) {
        return
    }

    if (index == digits.size) {
        c = c.coerceAtLeast(v)
        return
    }

    digits.indices.forEach { i ->
        if (!isVisited[i]) {
            isVisited[i] = true
            combination[index] = digits[i]
            combination(index + 1, v * 10 + digits[i], b)
            isVisited[i] = false
        }
    }
}
