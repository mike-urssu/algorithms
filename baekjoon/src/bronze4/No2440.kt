package bronze4

/**
 * https://www.acmicpc.net/problem/2440
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val number = reader.readLine().toInt()
    repeat(number) { i ->
        println("*".repeat(number - i))
    }
}