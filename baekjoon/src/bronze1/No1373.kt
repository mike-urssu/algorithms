package bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1373
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val binary = appendLeadingZero(reader.readLine())
    for (i in 0 until binary.length / 3) {
        writer.write("${binaryToOctal(binary, i * 3)}")
    }
    writer.flush()
}

private fun appendLeadingZero(input: String) =
    if (input.length % 3 == 0) {
        input
    } else {
        "0".repeat(3 - input.length % 3) + input
    }

private fun binaryToOctal(binary: String, index: Int): Int {
    var sum = 0
    if (binary[index].digitToInt() == 1) {
        sum += 4
    }
    if (binary[index + 1].digitToInt() == 1) {
        sum += 2
    }
    if (binary[index + 2].digitToInt() == 1) {
        sum += 1
    }
    return sum
}
