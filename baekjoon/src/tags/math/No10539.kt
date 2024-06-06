package tags.math

/**
 * https://www.acmicpc.net/problem/10539
 */
fun main() {
    val n = readln().toInt()
    val arrayB = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    (1..n).forEach { i -> arrayB[i] *= i }

    val arrayA = IntArray(n + 1).apply {
        (n downTo 1).forEach { i -> this[i] = arrayB[i] - arrayB[i - 1] }
    }
    println(arrayA.takeLast(n).joinToString(" "))
}
