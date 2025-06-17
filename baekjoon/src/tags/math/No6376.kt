package tags.math

/**
 * https://www.acmicpc.net/problem/6376
 */
fun main() {
    val factorial = IntArray(10).apply {
        this[0] = 1
        this[1] = 1
        (2 until 10).forEach { i -> this[i] = this[i - 1] * i }
    }
    println(
        """
            n e
            - -----------
            0 1
            1 2
            2 2.5
    """.trimIndent()
    )
    (3..9).forEach { i ->
        val sum = (0..i).sumOf { 1.0 / factorial[it] }
        println("$i ${String.format("%.9f", sum)}")
    }
}
