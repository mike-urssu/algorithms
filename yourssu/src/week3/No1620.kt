package week3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1620
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val pocketMonsAsMap = mutableMapOf<String, Int>()
    val pocketMonsAsList = mutableListOf<String>()
    val input = reader.readLine().split(" ").map { it.toInt() }

    repeat(input[0]) { index ->
        val pocketMon = reader.readLine()
        pocketMonsAsMap[pocketMon] = index + 1
        pocketMonsAsList.add(pocketMon)
    }

    repeat(input[1]) {
        val question = reader.readLine()
        if (pocketMonsAsMap.containsKey(question))
            writer.write("${pocketMonsAsMap[question]}")
        else
            writer.write(pocketMonsAsList[question.toInt() - 1])
        writer.newLine()
    }

    writer.flush()
}