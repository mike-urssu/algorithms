package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10867
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numbers = BooleanArray(2001)
    reader.readLine()
    reader.readLine().split(' ').map {
        numbers[it.toInt() + 1000] = true
    }

    for (i in numbers.indices) {
        if (numbers[i])
            writer.write("${i - 1000} ")
    }
    writer.flush()
}
