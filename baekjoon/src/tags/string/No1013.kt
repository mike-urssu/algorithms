package tags.string

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1013
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    val patterns = Array(numberOfInput) { reader.readLine() }

    val regEx = Regex("(100+1+|01)+")
    patterns.forEach { pattern ->
        writer.write(if (pattern.matches(regEx)) "YES" else "NO")
        writer.newLine()
    }

    writer.flush()
}
