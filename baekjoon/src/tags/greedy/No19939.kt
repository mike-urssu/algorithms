package tags.greedy

/**
 * https://www.acmicpc.net/problem/19939
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val sum = (1..k).sum()
    val gap = if (n < sum) {
        -1
    } else if ((n - sum) % k == 0) {
        k - 1
    } else {
        k
    }
    println(gap)
}
