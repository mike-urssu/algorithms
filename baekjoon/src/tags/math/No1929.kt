package tags.math

/**
 * https://www.acmicpc.net/problem/1929
 */
fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }

    val isPrime = getPrimes()
    (m..n)
        .filter { isPrime[it] }
        .forEach { println(it) }
}

private fun getPrimes(): BooleanArray {
    val isPrime = BooleanArray(1000001) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..1000) {
        for (j in i * i..1000000 step i) {
            isPrime[j] = false
        }
    }
    return isPrime
}
