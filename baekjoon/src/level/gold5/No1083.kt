package level.gold5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1083
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = reader.readLine().toInt()
    val numbers = reader.readLine().split(" ").map { it.toInt() }.toMutableList()
    var s = reader.readLine().toInt()

    for (i in 0 until n) {
        var max = numbers[i]
        var distance = 0

        for (j in i + 1 until n) {
            if (j - i > s) {
                break
            }

            if (numbers[j] > max) {
                max = numbers[j]
                distance = j - i
            }
        }

        for (j in i + distance downTo i + 1) {
            swap(numbers, j, j - 1)
        }
        s -= distance

        if (s == 0) {
            break
        }
    }

    writer.write(numbers.joinToString(" "))
    writer.flush()
}

private fun swap(numbers: MutableList<Int>, src: Int, dest: Int) {
    val temp = numbers[src]
    numbers[src] = numbers[dest]
    numbers[dest] = temp
}
