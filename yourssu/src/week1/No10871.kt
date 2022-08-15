package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10871
 */

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val givenNumber = reader.readLine().split(" ").map { it.toInt() }[1]
    reader.readLine().split(" ").forEach { number ->
        if (number.toInt() < givenNumber)
            writer.write("$number ")
    }
    writer.flush()
}