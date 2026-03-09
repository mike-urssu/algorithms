package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/14563
 */
import kotlin.math.sqrt

fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toInt() }
    numbers.forEach {
        val sum = sumFactors(it)
        val v = if (sum < it) {
            "Deficient"
        } else if (sum == it) {
            "Perfect"
        } else {
            "Abundant"
        }
        println(v)
    }
}

private fun sumFactors(n: Int): Int {
    var sum = 0
    val sqrt = sqrt(n.toDouble()).toInt()
    for (i in 1..sqrt) {
        if (n % i == 0) {
            sum += i + n / i
        }
    }
    if (sqrt * sqrt == n) {
        sum -= sqrt
    }
    return sum - n
}
