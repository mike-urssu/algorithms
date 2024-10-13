package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/16938
 */
private var n = 0
private var l = 0
private var r = 0
private var x = 0
private lateinit var numbers: IntArray
private lateinit var isVisited: BooleanArray
private lateinit var combination: IntArray
private var count = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    l = input[1]
    r = input[2]
    x = input[3]
    numbers = readln().split(" ").map { it.toInt() }.sorted().toIntArray()

    (2..n).forEach { i ->
        combination = IntArray(i)
        isVisited = BooleanArray(n)
        (0 until n).forEach { j ->
            combination[0] = numbers[j]
            isVisited[j] = true
            combination(i, 1, j)
        }
    }

    println(count)
}

private fun combination(size: Int, index: Int, nIndex: Int) {
    if (index == size) {
        if (combination.last() - combination.first() >= x && combination.sum() in l..r) {
            count++
        }
        return
    }

    (nIndex + 1 until n).forEach { i ->
        combination[index] = numbers[i]
        isVisited[i] = true
        combination(size, index + 1, i)
    }
}
