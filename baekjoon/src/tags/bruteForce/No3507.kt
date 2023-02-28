package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/3507
 */
fun main() {
    val n = readln().toInt()

    var count = 0
    for (i in 0..99) {
        for (j in 0..99) {
            if (n - i - j == 0) {
                count++
            }
        }
    }

    println(count)
}
