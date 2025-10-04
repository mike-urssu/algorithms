package tags.math

/**
 * https://www.acmicpc.net/problem/24039
 */
fun main() {
    val isPrime = BooleanArray(226) { true }
    isPrime[0] = false
    isPrime[1] = false
    (2..25).forEach { i ->
        (i * i..225 step i).forEach { j ->
            isPrime[j] = false
        }
    }
    val primes = (1..225).filter { isPrime[it] }
    val multiples = (0 until primes.lastIndex).map { i -> primes[i] * primes[i + 1] }

    val n = readln().toInt()
    println(multiples.first { it > n })
}
