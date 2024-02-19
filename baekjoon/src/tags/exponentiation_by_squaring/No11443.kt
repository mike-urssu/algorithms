package tags.exponentiation_by_squaring

/**
 * https://www.acmicpc.net/problem/11443
 */
fun main() {
    val n = readln().toLong()
    if (n % 2 == 0L) {
        println(fibonacci(n + 1) - 1)
    } else {
        println(fibonacci(n) - 1)
    }
}

private val memory = mutableMapOf<Long, Long>().apply {
    this[0] = 0
    this[1] = 1
}

private const val MOD = 1_000_000_007

private fun fibonacci(n: Long): Long {
    return memory[n] ?: run {
        val fN = fibonacci(n / 2)
        if (n % 2 == 0L) {
            val fM = fibonacci(n / 2 - 1)
            ((fN + fM) * fN + fN * fM) % MOD
        } else {
            val fM = fibonacci(n / 2 + 1)
            (fN * fN + fM * fM) % MOD
        }.also { memory[n] = it }
    }
}
