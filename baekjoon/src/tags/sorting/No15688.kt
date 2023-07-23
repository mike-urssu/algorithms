package tags.sorting

/**
 * https://www.acmicpc.net/problem/15688
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val n = reader.readLine().toInt()
    val numbers = IntArray(n) { reader.readLine().toInt() }
    numbers.sort()
    val answer = StringBuilder().apply {
        numbers.forEach { this.append(it).append("\n") }
    }
    println(answer)
}
