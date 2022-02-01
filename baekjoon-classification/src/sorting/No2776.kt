package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2776
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val testCase = reader.readLine().toInt()
    for (i in 0 until testCase) {
        reader.readLine().toInt()
        val numbers = HashSet<Int>()
        reader.readLine().split(' ').map { numbers.add(it.toInt()) }
        reader.readLine()
        val numbers2 = reader.readLine().split(' ').map { it.toInt() }.toIntArray()

        for (number in numbers2) {
            if (numbers.contains(number))
                writer.write("1")
            else
                writer.write("0")
            writer.newLine()
        }
    }
    writer.flush()
}
