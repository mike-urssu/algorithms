package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2437
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val weights = reader.readLine().split(' ').map { it.toInt() }.toIntArray().sortedArray()
    if (weights[0] > 1) {
        writer.write((1).toString())
        writer.flush()
        return
    }

    var sum = 0
    for (i in weights.indices) {
        if (sum + 1 < weights[i])
            break
        else
            sum += weights[i]
    }
    writer.write((sum + 1).toString())
    writer.flush()
}
