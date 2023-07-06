package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/9094
 */
fun main() {
    val testCase = readln().toInt()
    repeat(testCase) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        var count = 0
        for (a in 1 until n - 1) {
            for (b in a + 1 until n) {
                val r = (a * a + b * b + m).toDouble() / (a * b)
                if (r == r.toInt().toDouble()) {
                    count++
                }
            }
        }
        println(count)
    }
}
