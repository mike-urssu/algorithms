package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1747
 */
import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    val primes = getPrimes()
    var i = n
    while (true) {
        if (primes[i] && isPalindrome(i.toString())) {
            break
        }
        i++
    }
    println(i)
}

private fun getPrimes() =
    BooleanArray(1003002) { true }
        .apply {
            this[0] = false
            this[1] = false
            (2..sqrt(1003002.0).toInt()).forEach { i ->
                (i * i until 1003002 step i).forEach { j ->
                    this[j] = false
                }
            }
        }

private fun isPalindrome(n: String): Boolean {
    for (i in 0 until n.length / 2) {
        if (n[i] != n[n.lastIndex - i]) {
            return false
        }
    }
    return true
}
