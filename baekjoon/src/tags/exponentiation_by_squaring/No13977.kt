package tags.exponentiation_by_squaring

/**
 * https://www.acmicpc.net/problem/13977
 */
private lateinit var factorial: LongArray
private const val p = 1_000_000_007

fun main() {
    factorial = getFactorial()
    val m = readln().toInt()
    repeat(m) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        println(combination(n, k))
    }
}

private fun getFactorial(): LongArray {
    val factorial = LongArray(4_000_001)
    factorial[0] = 1
    (1..4_000_000).forEach { i ->
        factorial[i] = (factorial[i - 1] * i) % p
    }
    return factorial
}

private fun combination(n: Int, k: Int) =
    factorial[n] * pow((factorial[k] * factorial[n - k]) % p, p - 2) % p


private fun pow(n: Long, c: Int): Long {
    return if (c == 0) {
        1
    } else if (c == 1) {
        n
    } else {
        val halfPow = pow(n, c / 2)
        if (c % 2 == 0) {
            (halfPow * halfPow) % p
        } else {
            ((halfPow * halfPow) % p) * n % p
        }
    }
}
