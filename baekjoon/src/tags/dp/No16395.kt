package tags.dp

/**
 * https://www.acmicpc.net/problem/16395
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val combination = getCombination()
    println(combination[n][k])
}

private fun getCombination(): Array<IntArray> {
    val combination = Array(31) { IntArray(31) }
    for (i in 1..30) {
        for (j in 1..i) {
            combination[i][j] = if (j == 1 || j == i) {
                1
            } else {
                combination[i - 1][j - 1] + combination[i - 1][j]
            }
        }
    }
    return combination
}
