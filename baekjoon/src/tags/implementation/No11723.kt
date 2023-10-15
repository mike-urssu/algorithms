package tags.implementation

/**
 * https://www.acmicpc.net/problem/11723
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))
private val numbers = BooleanArray(21)

fun main() {
    val m = reader.readLine().toInt()
    repeat(m) {
        val command = reader.readLine().split(" ")
        when (command[0]) {
            "add" -> {
                numbers[command[1].toInt()] = true
            }

            "remove" -> {
                numbers[command[1].toInt()] = false
            }

            "check" -> {
                if (numbers[command[1].toInt()]) {
                    writer.write("1\n")
                } else {
                    writer.write("0\n")
                }
            }

            "toggle" -> {
                numbers[command[1].toInt()] = !numbers[command[1].toInt()]
            }

            "all" -> {
                (1..20).forEach { i -> numbers[i] = true }
            }

            "empty" -> {
                (1..20).forEach { i -> numbers[i] = false }
            }
        }
    }
    writer.flush()
}
