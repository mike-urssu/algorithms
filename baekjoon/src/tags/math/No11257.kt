package tags.math

/**
 * https://www.acmicpc.net/problem/11257
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (ip, a, b, c) = readln().split(" ").map { it.toInt() }
        val sum = a + b + c
        val isPass = if (sum < 55 || a / 35.0 < 0.3 || b / 25.0 < 0.3 || c / 40.0 < 0.3) {
            "FAIL"
        } else {
            "PASS"
        }
        println("$ip $sum $isPass")
    }
}
