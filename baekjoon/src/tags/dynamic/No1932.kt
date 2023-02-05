package tags.dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/1932
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val triangle = Array(numberOfInput) { i ->
        val tokenizer = StringTokenizer(reader.readLine())
        IntArray(i + 1) {
            tokenizer.nextToken().toInt()
        }
    }

    for (i in numberOfInput - 2 downTo 0) {
        for (j in 0 until triangle[i].size)
            triangle[i][j] += triangle[i + 1][j].coerceAtLeast(triangle[i + 1][j + 1])
    }

    writer.write(triangle[0][0].toString())
    writer.flush()
}