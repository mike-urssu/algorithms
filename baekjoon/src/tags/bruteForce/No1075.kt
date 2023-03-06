package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1075
 */
fun main() {
    val n = readln().toInt()
    val f = readln().toInt()

    for (i in n / 100 * 100..(n / 100 + 1) * 100) {
        if (i % f == 0) {
            println(String.format("%02d", i % 100))
            return
        }
    }
}
