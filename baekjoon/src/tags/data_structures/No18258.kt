package tags.data_structures

/**
 * https://www.acmicpc.net/problem/18258
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val queue = ArrayDeque<Int>()
    val n = reader.readLine().toInt()
    repeat(n) {
        val s = reader.readLine().split(" ")
        when (s[0]) {
            "push" -> queue.add(s[1].toInt())
            "pop" -> writer.write("${queue.removeFirstOrNull() ?: -1}\n")
            "size" -> writer.write("${queue.size}\n")
            "empty" -> if (queue.isEmpty()) {
                writer.write("1\n")
            } else {
                writer.write("0\n")
            }

            "front" -> writer.write("${queue.firstOrNull() ?: -1}\n")
            "back" -> writer.write("${queue.lastOrNull() ?: -1}\n")
        }
    }
    writer.flush()
}
