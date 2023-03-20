package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/14697
 */
fun main() {
    val (a, b, c, n) = readln().split(" ").map { it.toInt() }
    for (i in 0..n / a) {
        for (j in 0..n / b) {
            for (k in 0..n / c) {
                val sum = a * i + b * j + c * k
                if (sum > n) {
                    break
                } else if (sum == n) {
                    println(1)
                    return
                }
            }
        }
    }
    println(0)
}
