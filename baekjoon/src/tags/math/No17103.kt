package tags.math

/**
 * https://www.acmicpc.net/problem/17103
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(goldBach(n))
    }
}

private val primes = getPrimes()

private fun getPrimes(): BooleanArray {
    val primes = BooleanArray(1000001) { true }
    primes[0] = false
    primes[1] = false
    for (i in 2..1000) {
        for (j in i * i..1000000 step i) {
            primes[j] = false
        }
    }
    return primes
}

private fun goldBach(n: Int): Int {
    var count = 0
    for (i in 2..n / 2) {
        if (primes[i] && primes[n - i]) {
            count++
        }
    }
    return count
}
