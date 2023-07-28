package tags.greedy

/**
 * https://www.acmicpc.net/problem/14916
 */
fun main() {
    val n = readln().toInt()
    for (i in n / 5 downTo 0) {
        for (j in (n - 5 * i) / 2 downTo 0) {
            if (i * 5 + j * 2 == n) {
                println(i + j)
                return
            }
        }
    }
    println(-1)
}
