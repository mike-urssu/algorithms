package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2246
 */
fun main() {
    val n = readln().toInt()
    val distances = IntArray(n)
    val costs = IntArray(n)

    for(i in 0 until n) {
        val (d, c) = readln().split(" ").map { it.toInt() }
        distances[i] = d
        costs[i] = c
    }

    val count = (0 until n).count { isCandidate(n, distances, costs, it) }
    println(count)
}

private fun isCandidate(n: Int, distances: IntArray, costs: IntArray, index: Int): Boolean {
    val distance = distances[index]
    val cost = costs[index]
    for (i in 0 until n) {
        if (i == index) {
            continue
        }
        if (distances[i] <= distance && costs[i] <= cost) {
            return false
        }
    }
    return true
}
