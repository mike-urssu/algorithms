package tags.math

/**
 * https://www.acmicpc.net/problem/4388
 */
fun main() {
    while (true) {
        val (a, b) = readln().split(" ").map { it.toInt() }.sortedDescending()
        if (a == 0 && b == 0) {
            break
        }
        println(countCarry(a, b))
    }
}

private fun countCarry(a: Int, b: Int): Int {
    var a = a
    var b = b
    var count = 0
    var carry = 0
    while (a > 0 && b > 0) {
        val sum = a % 10 + b % 10 + carry
        if (sum >= 10) {
            count++
            carry = 1
        } else {
            carry = 0
        }
        a /= 10
        b /= 10
    }
    while (a > 0) {
        val sum = a % 10 + carry
        if (sum >= 10) {
            count++
            carry = 1
        } else {
            carry = 0
        }
        a /= 10
    }
    return count
}
