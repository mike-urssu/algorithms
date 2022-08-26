package week3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1764
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val input = reader.readLine().split(" ").map { it.toInt() }
    val namesAsSet = mutableSetOf<String>()
    val names = mutableListOf<String>()
    repeat(input[0]) {
        val name = reader.readLine()
        namesAsSet.add(name)
    }

    repeat(input[1]) {
        val name = reader.readLine()
        if (namesAsSet.contains(name))
            names.add(name)
    }

    writer.write("${names.size}")
    writer.newLine()
    names.sorted().forEach { name ->
        writer.write(name)
        writer.newLine()
    }
    writer.flush()
}