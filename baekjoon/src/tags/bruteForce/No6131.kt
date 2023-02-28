package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/6131
 */
fun main() {
    val n = readln().toInt()
    var count = 0
    for (b in 1..500) {
        for (a in b..500) {
            if (a * a == b * b + n) {
                count++
            }
        }
    }
    println(count)
}
