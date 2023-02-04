package bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

/**
 * https://www.acmicpc.net/problem/4696
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    while (true) {
        val number = reader.readLine().toDouble()
        if (number == 0.0) {
            break
        }
        writer.write("${String.format("%.2f", 1 + number + number.pow(2) + number.pow(3) + number.pow(4))}\n")
    }
    writer.flush()
}
