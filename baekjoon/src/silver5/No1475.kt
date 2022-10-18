package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1475
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = mutableMapOf<Int, Int>()
    reader.readLine().replace("9", "6").forEach {
        val number = it.digitToInt()
        numbers[number] = numbers.getOrDefault(number, 0) + 1
    }
    if (numbers.containsKey(6)) {
        numbers[6] = (numbers[6]!! + 1) / 2
    }

    writer.write("${numbers.maxOf { it.value }}")
    writer.flush()
}