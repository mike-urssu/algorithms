package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1541
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val expression = reader.readLine()

    val numbers = expression.split('-', '+').map { number -> number.toInt() }
    var index = 1

    var isPositive = true
    var sum = numbers[0]
    for (i in expression.indices) {
        if (expression[i] == '+') {
            if (isPositive)
                sum += numbers[index++]
            else {
                sum -= numbers[index++]
                isPositive = false
            }
        } else if (expression[i] == '-') {
            sum -= numbers[index++]
            isPositive = false
        }
    }
    writer.write(sum.toString())
    writer.flush()
}
