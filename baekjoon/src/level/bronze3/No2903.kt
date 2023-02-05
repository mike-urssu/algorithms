package level.bronze3

/**
 * https://www.acmicpc.net/problem/2903
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    writer.write("${(2.0.pow(reader.readLine().toDouble()) + 1).pow(2).toInt()}")
    writer.flush()
}
