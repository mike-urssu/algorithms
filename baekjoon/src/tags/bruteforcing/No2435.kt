package tags.bruteforcing

import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2435
 */
fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val k = scanner.nextInt()
    val temperatures = IntArray(n) { scanner.nextInt() }

    var sum = temperatures.take(k).sum()
    var max = sum
    for (i in k until n) {
        sum = sum - temperatures[i - k] + temperatures[i]
        max = max.coerceAtLeast(sum)
    }
    println(max)
}
