package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/15667
 */
fun main() {
    val n = readln().toInt()
    val k = (1..100).find {
        val sum = 1 + it + it * it
        sum == n
    }!!
    println(k)
}
