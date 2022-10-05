package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet

/**
 * https://www.acmicpc.net/problem/5597
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = TreeSet<Int>()
    repeat(30) { numbers.add(it + 1) }

    repeat(28) {
        val number = reader.readLine().toInt()
        numbers.remove(number)
    }

    numbers.forEach { writer.write("$it\n") }
    writer.flush()
}