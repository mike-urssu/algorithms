package tags.math

/**
 * https://www.acmicpc.net/problem/30666
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val isPrime = getPrimes()
    val primeNumbers = (2..1_000_000).filter { i -> isPrime[i] }
    val prefixSum = primeNumbers.runningFold(0, Int::plus)

    val validNumbers = getValidNumbers(primeNumbers, prefixSum)

    val result = StringBuilder()
    while (true) {
        val n = reader.readLine().toInt()
        if (n == 0) {
            break
        }

        if (validNumbers.contains(n)) {
            result.append("SIM\n")
        } else {
            result.append("NAO\n")
        }
    }
    println(result)
}

private fun getValidNumbers(primeNumbers: List<Int>, prefixSum: List<Int>): Set<Int> {
    val validNumbers = mutableSetOf<Int>()
    for (i in primeNumbers.indices) {
        for (primeNumber in primeNumbers) {
            if (i + primeNumber >= prefixSum.size) {
                break
            }

            val value = prefixSum[i + primeNumber] - prefixSum[i]
            if (value > 1_000_000) {
                break
            }
            validNumbers.add(value)
        }
    }
    return validNumbers
}

private fun getPrimes(): BooleanArray {
    val primes = BooleanArray(1_000_001) { true }
    primes[0] = false
    primes[1] = false
    (2..1000).forEach { i ->
        (i * i..1_000_000 step i).forEach { j ->
            primes[j] = false
        }
    }
    return primes
}
