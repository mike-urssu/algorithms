package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10610
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberInString = reader.readLine()
    var sum = 0
    for (digit in numberInString)
        sum += digit.digitToInt()
    if (!numberInString.contains('0') || sum % 3 != 0)
        writer.write("-1")
    else
        writer.write(numberInString.toCharArray().sortedArrayDescending())
    writer.flush()
}
