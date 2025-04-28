package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/11502
 */
private lateinit var primes: List<Int>

fun main() {
    primes = getPrime()

    val t = readln().toInt()
    repeat(t) {
        val k = readln().toInt()
        val (a, b, c) = find(k)
        println("$a $b $c")
    }
}

private fun getPrime(): List<Int> {
    val isPrime = BooleanArray(1000) { true }
    isPrime[0] = false
    isPrime[1] = false
    (2..33).forEach { i ->
        (i * i until 1000 step i).forEach { j ->
            isPrime[j] = false
        }
    }

    return (0 until 1000).filter { isPrime[it] }
}

private fun find(n: Int): IntArray {
    for (i in 0 until primes.size - 2) {
        for (j in i until primes.size - 1) {
            for (k in i until primes.size) {
                if (primes[i] + primes[j] + primes[k] == n) {
                    return intArrayOf(primes[i], primes[j], primes[k])
                }
            }
        }
    }
    return intArrayOf(-1, -1, -1)
}
