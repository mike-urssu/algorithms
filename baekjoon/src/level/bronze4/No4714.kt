package level.bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.text.DecimalFormat

/**
 * https://www.acmicpc.net/problem/4714
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private val formatter = DecimalFormat("0.00")
fun main() {
    while (true) {
        val weight = reader.readLine().toDouble()
        if (weight == -1.0) {
            break
        }
        val weightInMoon = weight * 0.167
        writer.write("Objects weighing ${formatter.format(weight)} on Earth will weigh ${formatter.format(weightInMoon)} on the moon.\n")
    }
    writer.flush()
}
