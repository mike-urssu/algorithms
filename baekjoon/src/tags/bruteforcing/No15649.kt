package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/15649
 */
private lateinit var combination: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    combination = IntArray(m)
    isVisited = BooleanArray(n + 1)
    combination(n, m, 0)
}

private fun combination(n: Int, r: Int, index: Int) {
    if (index == r) {
        println(combination.joinToString(" "))
        return
    }

    (1..n).forEach { i ->
        if (!isVisited[i]) {
            isVisited[i] = true
            combination[index] = i
            combination(n, r, index + 1)
            isVisited[i] = false
        }
    }
}
