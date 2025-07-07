package tags.greedy

/**
 * https://www.acmicpc.net/problem/12018
 */
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val m = scanner.nextInt()
    val scoresRequired = (0 until n).map {
        val p = scanner.nextInt()
        val l = scanner.nextInt()
        val mileages = IntArray(p) { scanner.nextInt() }
        if (p < l) {
            1
        } else {
            mileages.sortedDescending()[l - 1]
        }
    }.sorted()

    val prefixSum = scoresRequired.runningFold(0, Int::plus)
    println(prefixSum.indexOfLast { it <= m })
}
