package tags.math

/**
 * https://www.acmicpc.net/problem/2023
 */
import kotlin.math.sqrt

private lateinit var combination: IntArray

fun main() {
    val n = readln().toInt()
    combination = IntArray(n)
    findMysteriousPrimes(n, 0)
}

private fun findMysteriousPrimes(n: Int, index: Int) {
    val mysteriousPrime = getMysteriousPrime(index - 1)

    if (n == index) {
        println(mysteriousPrime)
        return
    }

    for (i in 0..9) {
        if (isPrime(mysteriousPrime * 10 + i)) {
            combination[index] = i
            findMysteriousPrimes(n, index + 1)
        }
    }
}

private fun getMysteriousPrime(index: Int): Int {
    var mysteriousPrime = combination[0]
    (1..index).forEach { i -> mysteriousPrime = mysteriousPrime * 10 + combination[i] }
    return mysteriousPrime
}

private fun isPrime(n: Int) =
    n >= 2 && (2..sqrt(n.toDouble()).toInt()).all { i -> n % i != 0 }
