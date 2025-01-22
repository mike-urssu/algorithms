package tags.data_structures

/**
 * https://www.acmicpc.net/problem/22233
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val keywords = mutableSetOf<String>()
    repeat(n) {
        keywords.add(reader.readLine())
    }
    repeat(m) {
        reader.readLine().split(",").forEach { keywords.remove(it) }
        writer.write("${keywords.size}\n")
    }
    writer.flush()
}
