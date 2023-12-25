package tags.exponentiation_by_squaring

/**
 * https://www.acmicpc.net/problem/13172
 */
private const val p = 1_000_000_007

fun main() {
    val m = readln().toInt()
    val sum = sum(m)
    println(sum)
}

private fun sum(m: Int): Long {
    val sum = (0 until m).sumOf {
        val (n, s) = readln().split(" ").map { it.toInt() }
        (s % p) * pow(n, p - 2) % p
    }
    return sum % p
}

private fun pow(n: Int, m: Int): Long {
    if (m == 1) {
        return n.toLong()
    }

    val halfPow = pow(n, m / 2) % p
    return if (m % 2 == 0) {
        halfPow * halfPow % p
    } else {
        (halfPow * halfPow % p) * n % p
    }
}
