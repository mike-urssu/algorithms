package tags.sorting

/**
 * https://www.acmicpc.net/problem/14469
 */
fun main() {
    val n = readln().toInt()
    val cows = Array(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        a to b
    }
    cows.sortBy { it.first }

    var t = 0
    cows.forEach { (a, b) ->
        if (t <= a) {
            t = a
        }
        t += b
    }
    println(t)
}
