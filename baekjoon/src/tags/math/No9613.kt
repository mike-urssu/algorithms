package tags.math

/**
 * https://www.acmicpc.net/problem/9613
 */
import java.util.Scanner

private val writer = System.out.bufferedWriter()
private val reader = Scanner(System.`in`)

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = reader.nextInt()
        val numbers = IntArray(n) { reader.nextInt() }
        var sum = 0L
        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                sum += gcd(numbers[i], numbers[j])
            }
        }
        writer.write("$sum\n")
    }
    writer.flush()
}

private fun gcd(n: Int, m: Int): Int {
    return if (m == 0) {
        n
    } else {
        gcd(m, n % m)
    }
}
