package tags.binarySearchh

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/19637
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val names = mutableListOf<String>()
    val boundaries = mutableListOf<Int>()
    repeat(n) {
        val input = reader.readLine().split(" ")
        names.add(input[0])
        boundaries.add(input[1].toInt())
    }

    repeat(m) {
        val number = reader.readLine().toInt()
        val index = getLowerBound(boundaries, number)
        writer.write("${names[index]}\n")
    }
    writer.flush()
}

private fun getLowerBound(numbers: List<Int>, number: Int): Int {
    var low = -1
    var high = numbers.lastIndex
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (numbers[mid] >= number) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
