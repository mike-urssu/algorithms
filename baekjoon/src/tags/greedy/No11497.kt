package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/11497
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val testCase = reader.readLine().toInt()
    for (i in 0 until testCase) {
        reader.readLine().toInt()
        val logs = reader.readLine().split(' ').map { it.toInt() }.toIntArray().sortedArray()
        writer.write(getMinimumDifficulty(logs).toString())
        writer.newLine()
    }
    writer.flush()
}

private fun getMinimumDifficulty(logs: IntArray): Int {
    val optimizedLogs = IntArray(logs.size)
    var head = 0
    var tail = logs.size - 1

    for (i in logs.indices) {
        if (i % 2 == 0)
            optimizedLogs[head++] = logs[i]
        else
            optimizedLogs[tail--] = logs[i]
    }

    var minimumDifficulty = Int.MIN_VALUE
    for (i in 0 until optimizedLogs.size - 1)
        minimumDifficulty = minimumDifficulty.coerceAtLeast(abs(optimizedLogs[i] - optimizedLogs[i + 1]))
    minimumDifficulty = minimumDifficulty.coerceAtLeast(abs(optimizedLogs[optimizedLogs.size - 1] - optimizedLogs[0]))
    return minimumDifficulty
}
