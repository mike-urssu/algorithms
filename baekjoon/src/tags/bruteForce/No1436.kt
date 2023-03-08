package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1436
 */
fun main() {
    val n = readln().toInt()
    var number = 0
    var count = 0

    while (true) {
        if (count == n) {
            break
        }
        number++
        if (number.toString().contains("666")) {
            count++
        }
    }

    println(number)
}
