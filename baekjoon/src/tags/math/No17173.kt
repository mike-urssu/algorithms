package tags.math

/**
 * https://www.acmicpc.net/problem/17173
 */
fun main() {
    val (n, _) = readln().split(" ").map { it.toInt() }
    val isVisited = BooleanArray(n + 1)
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    numbers.forEach { i ->
        (i..n step i).forEach { j ->
            isVisited[j] = true
        }
    }
    println((1..n).filter { isVisited[it] }.sum())
}
