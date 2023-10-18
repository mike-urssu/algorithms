package tags.math

/**
 * https://www.acmicpc.net/problem/1978
 */
fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toInt() }

    val isPrime = getPrimes()
    println(numbers.count { isPrime[it] })
}

private fun getPrimes(): BooleanArray {
    val isPrime = BooleanArray(1001) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..31) {
        for (j in i * i..1000 step i) {
            isPrime[j] = false
        }
    }
    return isPrime
}
