package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/18312
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var count = 0
    for (h in 0..n) {
        for (m in 0 until 60) {
            for (s in 0 until 60) {
                if (h / 10 == k || h % 10 == k || m / 10 == k || m % 10 == k || s / 10 == k || s % 10 == k) {
                    count++
                }
            }
        }
    }
    println(count)
}
