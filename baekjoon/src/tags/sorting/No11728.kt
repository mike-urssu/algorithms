package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11728
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val sizes = reader.readLine().split(' ').map { it.toInt() }
    val firstList = reader.readLine().split(' ').map { it.toInt() }
    val secondList = reader.readLine().split(' ').map { it.toInt() }

    var i = 0
    var j = 0
    while (i < sizes[0] && j < sizes[1])
        writer.write("${if (firstList[i] <= secondList[j]) firstList[i++] else secondList[j++]} ")
    while (i < sizes[0])
        writer.write("${firstList[i++]} ")
    while (j < sizes[1])
        writer.write("${secondList[j++]} ")

    writer.flush()
}
