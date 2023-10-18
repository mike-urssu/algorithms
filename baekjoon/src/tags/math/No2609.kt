package tags.math

/**
 * https://www.acmicpc.net/problem/2609
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val gcd = getGCD(a, b)
    println(gcd)
    println(a * b / gcd)
}

private fun getGCD(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        getGCD(b, a % b)
    }
}
