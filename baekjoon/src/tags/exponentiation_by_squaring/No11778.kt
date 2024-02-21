package tags.exponentiation_by_squaring

/**
 * https://www.acmicpc.net/problem/11778
 */
private const val MOD = 1_000_000_007

fun main() {
    val (n, m) = readln().split(" ").map { it.toLong() }
    println(fibonacci(gcd(n, m)))
}

private val memory = mutableMapOf<Long, Long>().apply {
    this[0] = 0
    this[1] = 1
}

private fun fibonacci(n: Long): Long {
    return memory[n] ?: run {
        val fn = fibonacci(n / 2)
        if (n % 2 == 0L) {
            val fm = fibonacci(n / 2 - 1)
            ((fn + fm) * fn + fn * fm) % MOD
        } else {
            val fm = fibonacci(n / 2 + 1)
            (fn * fn + fm * fm) % MOD
        }
    }.also { memory[n] = it }
}

private fun gcd(n: Long, m: Long): Long {
    return if (m == 0L) {
        n
    } else {
        gcd(m, n % m)
    }
}
