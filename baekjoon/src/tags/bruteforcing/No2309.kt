package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2309
 */
fun main() {
    val heights = IntArray(9) { readln().toInt() }
    val sum = heights.sum()

    for (i in heights.indices) {
        for (j in heights.indices) {
            if (i == j) {
                continue
            }

            if (sum - heights[i] - heights[j] == 100) {
                heights[i] = Int.MAX_VALUE
                heights[j] = Int.MAX_VALUE

                heights.sorted().take(7).forEach { println(it) }
                return
            }
        }
    }
}
