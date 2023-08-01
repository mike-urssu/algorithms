package tags.greedy

/**
 * https://www.acmicpc.net/problem/1052
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var i = n
    while (i.countOneBits() > k) {
        i++
    }
    println(i - n)
}
