package tags.math

/**
 * https://www.acmicpc.net/problem/2960
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var count = 1
    val isErased = IntArray(n + 1)
    (2..n).forEach { i ->
        (i..n step i).forEach { j ->
            if (isErased[j] == 0) {
                isErased[j] = count++
            }
        }
    }
    println(isErased.indexOf(k))
}
