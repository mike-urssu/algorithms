package tags.backtracking

/**
 * https://www.acmicpc.net/problem/2992
 */
private var n = 0
private var min = Int.MAX_VALUE

private lateinit var numbers: IntArray
private lateinit var combination: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    val x = readln()

    n = x.toInt()
    numbers = x.map { it.digitToInt() }.toIntArray()
    combination = IntArray(x.length)
    isVisited = BooleanArray(x.length)

    combination(x.length, 0)
    if (min == Int.MAX_VALUE) {
        min = 0
    }
    println(min)
}

private fun combination(size: Int, r: Int) {
    if (r == size) {
        val v = combination.joinToString("").toInt()
        if (n < v) {
            min = minOf(min, v)
        }
        return
    }

    numbers.indices.forEach { i ->
        if (!isVisited[i]) {
            isVisited[i] = true
            combination[r] = numbers[i]
            combination(size, r + 1)
            isVisited[i] = false
        }
    }
}
