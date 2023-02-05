package level.bronze4

/**
 * https://www.acmicpc.net/problem/3046
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (r1, s) = reader.readLine().split(" ").map { it.toInt() }
    writer.write("${s * 2 - r1}")
    writer.flush()
}
