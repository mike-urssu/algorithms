package level.silver2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1059
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }.sorted()
    val number = reader.readLine().toInt()

    val from: Int
    val to: Int

    if (numbers.contains(number)) {
        from = 0
        to = 0
    } else if (number <= numbers.first()) {
        from = 1
        to = numbers.first() - 1
    } else {
        from = numbers.last { it < number } + 1
        to = numbers.first { it > number } - 1
    }
    writer.write("${getCount(from, to, number)}")
    writer.flush()
}

private fun getCount(from: Int, to: Int, number: Int): Int {
    var count = 0
    for (i in from..number) {
        for (j in i + 1..to) {
            if (number in i..j) {
                count++
            }
        }
    }
    return count
}
