package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/32710
 */
fun main() {
    val n = readln().toInt()
    var isValid = 0
    for (i in 1..9) {
        for (j in 1..9) {
            if (i * j == n) {
                isValid = 1
            }
        }
    }
    println(isValid)
}
