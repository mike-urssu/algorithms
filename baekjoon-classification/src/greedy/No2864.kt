package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2864
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numbers = reader.readLine().split(' ')

    writer.write("${getMinimumSum(numbers)} ${getMaximumSum(numbers)}")
    writer.flush()
}

fun getMinimumSum(numbers: List<String>): Int {
    return numbers[0].replace('6', '5').toInt() + numbers[1].replace('6', '5').toInt()
}

fun getMaximumSum(numbers: List<String>): Int {
    return numbers[0].replace('5', '6').toInt() + numbers[1].replace('5', '6').toInt()
}
