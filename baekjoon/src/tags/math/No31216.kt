package tags.math

/**
 * https://www.acmicpc.net/problem/31216
 */
fun main() {
    val primes = getPrimes()
    val superPrimes = getSuperPrimes(primes)

    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(superPrimes[n])
    }
}

private fun getPrimes(): List<Int> {
    val primes = BooleanArray(1_000_001) { true }
    primes[0] = false
    primes[1] = false
    (2..1000).forEach { i ->
        (i * i..1_000_000 step i).forEach { j ->
            primes[j] = false
        }
    }
    return (0..1_000_000).filter { primes[it] }
}

private fun getSuperPrimes(primes: List<Int>): List<Int> {
    val superPrimes = mutableListOf<Int>()
    superPrimes.add(0)
    var index = 0
    while (superPrimes.size <= 3000) {
        superPrimes.add(primes[primes[index] - 1])
        index++
    }
    return superPrimes
}
