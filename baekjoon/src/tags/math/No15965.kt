package tags.math

/**
 * https://www.acmicpc.net/problem/15965
 */
fun main() {
    val isPrime = BooleanArray(10_000_001) { true }
    isPrime[0] = false
    isPrime[1] = false
    (2..3162).forEach { i ->
        (i * i..10_000_000 step i).forEach { j ->
            isPrime[j] = false
        }
    }
    val primes = (1..10_000_000).filter { isPrime[it] }

    val k = readln().toInt() - 1
    println(primes[k])
}
