package tags.string

/**
 * https://www.acmicpc.net/problem/20920
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val words = mutableMapOf<String, Int>()
        .apply {
            repeat(n) {
                val word = reader.readLine()
                this[word] = (this[word] ?: 0) + 1
            }
        }

    words.entries
        .filter { it.key.length >= m }
        .sortedWith { it, other ->
            if (it.value != other.value) {
                -it.value.compareTo(other.value)
            } else {
                if (it.key.length != other.key.length) {
                    -it.key.length.compareTo(other.key.length)
                } else {
                    it.key.compareTo(other.key)
                }
            }
        }
        .forEach { writer.write("${it.key}\n") }
    writer.flush()
}
