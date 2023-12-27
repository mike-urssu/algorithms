package tags.two_pointer

/**
 * https://www.acmicpc.net/problem/1644
 */
fun main() {
    val n = readln().toInt()
    println(combination(n))
}

private fun combination(n: Int): Int {
    val primes = getPrimes()
    val prefixSum = primes.runningFold(0, Int::plus)

    var count = 0
    var left = 0
    var right = 1

    while (right < prefixSum.size) {
        val sum = prefixSum[right] - prefixSum[left]
        if (sum > n) {
            left++
            if (left == right) {
                right++
            }
        } else if (sum == n) {
            left++
            right++
            count++
        } else {
            right++
        }
    }

    return count
}

private fun getPrimes(): List<Int> {
    val primes = BooleanArray(4_000_001) { true }
    primes[0] = false
    primes[1] = false
    (2..2000).forEach { i ->
        (i * i..4_000_000 step i).forEach { j ->
            primes[j] = false
        }
    }
    return (2..4_000_000).filter { primes[it] }
}
