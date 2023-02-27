package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2501
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val factors = (1..n).filter { n % it == 0 }
    if (factors.size < k) {
        println(0)
    } else {
        println(factors[k - 1])
    }
}
