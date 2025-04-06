package tags.math

/**
 * https://www.acmicpc.net/problem/2622
 */
fun main() {
    val n = readln().toInt()
    var count = 0
    for (i in (n + 1) / 2 downTo (n + 2) / 3) {
        for (j in i downTo 1) {
            val k = n - i - j
            if (k > j || i >= j + k) {
                break
            }
            count++
        }
    }
    println(count)
}
