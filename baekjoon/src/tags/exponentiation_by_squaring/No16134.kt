package tags.exponentiation_by_squaring

/**
 * https://www.acmicpc.net/problem/16134
 */
private const val p = 1_000_000_007

fun main() {
    val (n, r) = readln().split(" ").map { it.toInt() }
    println(combination(n, r))
}

/**
 * 페르마의 소정리
 * (n! / (r! * (n-r)!)) % p
 * = (n! * ((r! * (n-r)!) ^ (-1))) % p
 * = ((n! % p) * ((r! * (n-r)!) ^ (p-2)) % p) % p
 */
private fun combination(n: Int, r: Int) =
    (factorial(n) % p) * pow((factorial(r) * factorial(n - r)) % p, p - 2) % p

private fun factorial(n: Int) =
    (1..n).fold(1L) { acc, it -> (acc * it) % p }

private fun pow(n: Long, c: Int): Long {
    if (c == 1) {
        return n
    }

    val halfPow = pow(n, c / 2)
    return if (c % 2 == 0) {
        (halfPow * halfPow) % p
    } else {
        ((halfPow * halfPow) % p) * n % p
    }
}
