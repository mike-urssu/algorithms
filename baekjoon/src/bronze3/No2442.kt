package bronze3

/**
 * https://www.acmicpc.net/problem/2442
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()
    for (i in 0 until number) {
        writer.write(" ".repeat(number - i - 1))
        writer.write("${"*".repeat(2 * i + 1)}\n")
    }
    writer.flush()
}
