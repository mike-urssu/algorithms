package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1439
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val string = reader.readLine()
    val zerosAndOnes = mutableListOf<Char>()
    zerosAndOnes.add(string[0])
    for (i in 1 until string.length) {
        if (string[i] != zerosAndOnes.last()) {
            zerosAndOnes.add(string[i])
        }
    }

    writer.write("${zerosAndOnes.count { it == '0' }.coerceAtMost(zerosAndOnes.count { it == '1' })}")
    writer.flush()
}