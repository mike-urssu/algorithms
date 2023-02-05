package level.bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1356
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine()
    var match = false
    for (i in 1 until number.length) {
        val number1 = number.substring(0, i)
        val number2 = number.substring(i)
        if (getMultiple(number1) == getMultiple(number2)) {
            match = true
            break
        }
    }

    if (match) {
        writer.write("YES")
    } else {
        writer.write("NO")
    }
    writer.flush()
}

private fun getMultiple(number: String): Int {
    var multiple = 1
    number.forEach { multiple *= it.digitToInt() }
    return multiple
}
