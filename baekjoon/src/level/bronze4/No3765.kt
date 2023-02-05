package level.bronze4

/**
 * https://www.acmicpc.net/problem/3765
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    while (true) {
        val input = reader.readLine() ?: break
        writer.write("${input}\n")
    }
    writer.flush()
}
