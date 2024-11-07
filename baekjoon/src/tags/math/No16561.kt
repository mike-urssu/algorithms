package tags.math

/**
 * https://www.acmicpc.net/problem/16561
 */
fun main() {
    val n = readln().toInt()
    var count = 0
    for (i in 3..n step 3) {
        for (j in 3..n step 3) {
            for (k in 3..n step 3) {
                if (i + j + k == n) {
                    count++
                }
            }
        }
    }
    println(count)
}
