package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/2632
 */
fun main() {
    val size = readln().toInt()
    val (m, n) = readln().split(" ").map { it.toInt() }
    val combination1 = getPizzas(m).filterNot { entry -> entry.key > size }
    val combination2 = getPizzas(n).filterNot { entry -> entry.key > size }

    val count = combination1.keys.sumOf { key ->
        val v1 = combination1[key]!!
        val v2 = combination2[size - key] ?: 0
        v1 * v2
    }
    println(count)
}

private fun getPizzas(size: Int): Map<Int, Int> {
    val pizza = IntArray(size) { readln().toInt() }
    val combination = sortedMapOf<Int, Int>()
    combination[0] = 1
    for (i in pizza.indices) {
        for (windowSize in 1 until size) {
            var sum = 0
            for (j in 0 until windowSize) {
                sum += pizza[(i + j) % size]
            }
            combination[sum] = (combination[sum] ?: 0) + 1
        }
    }
    combination[pizza.sum()] = 1
    return combination
}
