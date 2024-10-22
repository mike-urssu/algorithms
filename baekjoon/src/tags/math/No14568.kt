package tags.math

/**
 * https://www.acmicpc.net/problem/14568
 */
fun main() {
    val n = readln().toInt()
    var count = 0
    for (i in 2..n - 4 step 2) {
        for (j in 1 until n) {
            for (k in j + 2 until n) {
                val sum = i + j + k
                if (sum == n) {
                    count++
                    break
                } else if (sum > n) {
                    break
                }
            }
        }
    }
    println(count)
}
