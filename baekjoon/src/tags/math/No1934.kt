package tags.math

/**
 * https://www.acmicpc.net/problem/1934
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        println(lcm(a, b))
    }
}

private fun lcm(a: Int, b: Int) =
    a * b / gcd(a, b)

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        gcd(b, a % b)
    }
}
