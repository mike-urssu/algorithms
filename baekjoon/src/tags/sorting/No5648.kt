package tags.sorting

/**
 * https://www.acmicpc.net/problem/5648
 */
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val numbers = mutableListOf<String>()

    val n = scanner.nextInt()
    repeat(n) {
        numbers.add(scanner.next())
    }
    numbers.map { it.reversed().toLong() }
        .sorted()
        .forEach { println(it) }
}
