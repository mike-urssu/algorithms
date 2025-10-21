package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1270
 */
import java.util.Scanner

private val scanner = Scanner(System.`in`)

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val t = scanner.nextInt()
        val soldiers = LongArray(t) { scanner.nextLong() }

        val counts = mutableMapOf<Long, Int>()
        soldiers.forEach { counts[it] = (counts[it] ?: 0) + 1 }

        val (key, value) = counts.maxBy { it.value }
        if (value > t / 2) {
            println(key)
        } else {
            println("SYJKGW")
        }
    }
}
