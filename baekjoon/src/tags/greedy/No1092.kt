package tags.greedy

/**
 * https://www.acmicpc.net/problem/1092
 */
fun main() {
    readln()
    val weightLimits = readln().split(" ").map { it.toInt() }.sortedDescending().toIntArray()
    readln()
    val weights = readln().split(" ").map { it.toInt() }.sortedDescending().toIntArray()
    println(getMinutes(weights, weightLimits))
}

private fun getMinutes(weights: IntArray, weightLimits: IntArray): Int {
    if (weights.first() > weightLimits.first()) {
        return -1
    }

    var minutes = 0
    val isVisited = BooleanArray(weights.size)
    while (isVisited.any { !it }) {
        weightLimits.forEach { load(weights, isVisited, it) }
        minutes++
    }
    return minutes
}

private fun load(weights: IntArray, isVisited: BooleanArray, weightLimit: Int) {
    for (i in isVisited.indices) {
        if (!isVisited[i] && weights[i] <= weightLimit) {
            isVisited[i] = true
            return
        }
    }
}
