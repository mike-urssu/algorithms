package tags.backtracking

/**
 * https://www.acmicpc.net/problem/19942
 */
private var n = 0
private lateinit var requirements: IntArray
private lateinit var graph: Array<IntArray>
private lateinit var combination: BooleanArray
private var min = Int.MAX_VALUE
private var indices = listOf<Int>()

fun main() {
    n = readln().toInt()
    requirements = readln().split(" ").map { it.toInt() }.toIntArray()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    combination = BooleanArray(n)

    combination(0)

    if (min == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(min)
        println(indices.joinToString(" ") { "${it + 1}" })
    }
}

private fun combination(r: Int) {
    if (r == n) {
        val filteredIndices = (0 until n).filter { combination[it] }
        if (isValid(filteredIndices)) {
            val cost = filteredIndices.sumOf { graph[it].last() }
            if (cost < min) {
                min = cost
                indices = filteredIndices
            } else if (cost == min) {
                if (compare()) {
                    indices = filteredIndices
                }
            }
        }
        return
    }

    combination[r] = false
    combination(r + 1)
    combination[r] = true
    combination(r + 1)
}

private fun isValid(indices: List<Int>): Boolean {
    val prefixSum = IntArray(4)
    indices.forEach { i -> (0 until 4).forEach { prefixSum[it] += graph[i][it] } }
    return (0 until 4).all { requirements[it] <= prefixSum[it] }
}

private fun compare(): Boolean {
    val new = (0 until n).filter { combination[it] }.joinToString(" ")
    val old = indices.joinToString(" ")
    val c = new.compareTo(old)
    return c < 0
}
