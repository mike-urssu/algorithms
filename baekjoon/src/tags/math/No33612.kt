package tags.math

/**
 * https://www.acmicpc.net/problem/33612
 */
import java.time.LocalDate

fun main() {
    val n = readln().toInt()
    val next = LocalDate.of(2024, 1, 1).plusMonths(7L * n)
    println("${next.year} ${next.monthValue}")
}
