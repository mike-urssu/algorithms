package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1439
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val binary = reader.readLine()
    var min = Integer.MAX_VALUE
    min = min.coerceAtMost(getReverseZeroToOneCount(binary))
    min = min.coerceAtMost(getReverseOneToZeroCount(binary))

    writer.write(min.toString())
    writer.flush()
}

fun getReverseZeroToOneCount(binary: String): Int {
    var count = 0
    var isPreviousZero = false
    for (character in binary) {
        if (character == '0') {
            if (!isPreviousZero) {
                isPreviousZero = true
                count++
            }
        } else
            isPreviousZero = false
    }
    return count
}

fun getReverseOneToZeroCount(binary: String): Int {
    var count = 0
    var isPreviousOne = false
    for (character in binary) {
        if (character == '1') {
            if (!isPreviousOne) {
                isPreviousOne = true
                count++
            }
        } else
            isPreviousOne = false
    }
    return count
}
