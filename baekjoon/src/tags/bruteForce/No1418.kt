package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1418
 */
private val primes = IntArray(100001)

fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    setPrimes()
    println(primes.take(n + 1).count { it <= k } - 1)
}

private fun setPrimes() {
    primes[1] = 1
    for (i in 2..100000) {
        if (primes[i] != 0) {
            continue
        }
        for (j in i..100000 step i) {
            primes[j] = i
        }
    }
}
