package tags.string

/**
 * https://www.acmicpc.net/problem/14490
 */
fun main() {
    val (n, m) = readln().split(":").map { it.toInt() }
    val gcd = getGCD(n, m)
    println("${n / gcd}:${m / gcd}")
}

private fun getGCD(n: Int, m: Int): Int {
    return if (m == 0) {
        n
    } else {
        getGCD(m, n % m)
    }
}
