package tags.sorting

/**
 * https://www.acmicpc.net/problem/17224
 */
fun main() {
    val (n, l, k) = readln().split(" ").map { it.toInt() }
    val problems = Array(n) {
        val (s1, s2) = readln().split(" ").map { it.toInt() }
        s1 to s2
    }
    val scores = problems.map { (s1, s2) ->
        if (l >= s2) {
            140
        } else if (l >= s1) {
            100
        } else {
            0
        }
    }.sortedDescending()
    val sum = scores.take(k).sum()
    println(sum)
}
