package tags.exponentiation_by_squaring

/**
 * https://www.acmicpc.net/problem/11524
 */
fun main() {
    val p = readln().toInt()
    repeat(p) {
        val (k, y) = readln().split(" ").map { it.toLong() }
        println("$k ${fibonacci(y)}")
    }
}

private val memory = mutableMapOf<Long, Long>().apply {
    this[0] = 0
    this[1] = 1
}

private const val MOD = 1_000_000_000

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
