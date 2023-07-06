package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/25494
 */
fun main() {
    val testCase = readln().toInt()
    repeat(testCase) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        var count = 0
        for (i in 1..a) {
            for (j in 1..b) {
                for (k in 1..c) {
                    if (i % j == j % k && j % k == k % i) {
                        count++
                    }
                }
            }
        }
        println(count)
    }
}
