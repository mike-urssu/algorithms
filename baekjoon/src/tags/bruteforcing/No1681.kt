package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1681
 */
fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    var number = 1
    var count = 0

    while (true) {
        if (number.toString().all { it.digitToInt() != l }) {
            count++
        }
        if (n == count) {
            break
        }
        number++
    }

    println(number)
}
