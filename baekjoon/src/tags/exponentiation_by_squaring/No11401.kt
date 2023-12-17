package tags.exponentiation_by_squaring

/**
 * https://www.acmicpc.net/problem/11401
 */
private const val MOD = 1000000007

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    println(getBinomialCoefficient(n, k))
}

/**
 * 페르마의 정리
 * ((N! % MOD) * ((k! * (n - k)!).pow(MOD - 2) % MOD)) % MOD
 */
private fun getBinomialCoefficient(n: Int, k: Int): Long {
    val nFactorial = factorial(n)
    val divisor = pow((factorial(n - k) * factorial(k)) % MOD, MOD - 2)
    return (nFactorial * divisor) % MOD
}

private fun factorial(n: Int) =
    (1..n).fold(1L) { acc, i -> (acc * i) % MOD }

private fun pow(n: Long, c: Int): Long {
    if (c == 1) {
        return n
    }

    val halfPow = pow(n, c / 2) % MOD
    return if (c % 2 == 0) {
        (halfPow * halfPow) % MOD
    } else {
        (halfPow * halfPow) % MOD * n % MOD
    }
}
