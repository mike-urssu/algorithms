package tags.dp

/**
 * https://www.acmicpc.net/problem/2631
 */
fun main() {
    val n = readln().toInt()
    val numbers = IntArray(n) { readln().toInt() }
    val lcs = getLCS(n, numbers)
    println(n - lcs)
}

private fun getLCS(n: Int, numbers: IntArray): Int {
    val lcs = IntArray(n)
    for (i in 0 until n) {
        lcs[i] = 1
        for (j in 0 until i) {
            if (numbers[j] < numbers[i]) {
                lcs[i] = lcs[i].coerceAtLeast(lcs[j] + 1)
            }
        }
    }
    return lcs.max()
}
