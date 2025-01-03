package tags.math

/**
 * https://www.acmicpc.net/problem/5724
 */
fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) {
            break
        }
        val sum = (1..n).sumOf { it * it }
        println(sum)
    }
}
