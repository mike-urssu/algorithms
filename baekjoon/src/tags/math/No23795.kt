package tags.math

/**
 * https://www.acmicpc.net/problem/23795
 */
fun main() {
    var sum = 0
    while (true) {
        val n = readln().toInt()
        if (n == -1) {
            break
        }
        sum += n
    }
    println(sum)
}
