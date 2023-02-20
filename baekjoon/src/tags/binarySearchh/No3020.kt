package tags.binarySearchh

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/3020
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, h) = reader.readLine().split(" ").map { it.toInt() }
    val obstacles1 = mutableListOf<Int>()
    val obstacles2 = mutableListOf<Int>()
    repeat(n) {
        val number = reader.readLine().toInt()
        if (it % 2 == 0) {
            obstacles1.add(number)
        } else {
            obstacles2.add(h - number)
        }
    }
    obstacles1.sort()
    obstacles2.sort()

    val counts = sortedMapOf<Int, Int>()
    for (i in 1..h) {
        val o1 = n / 2 - getLowerBound(obstacles1, i)
        val o2 = getUpperBound(obstacles2, i - 1)
        counts[o1 + o2] = counts.getOrDefault(o1 + o2, 0) + 1
    }

    val min = counts.keys.min()
    writer.write("$min ${counts[min]}")
    writer.flush()
}

private fun getLowerBound(numbers: List<Int>, number: Int): Int {
    var low = -1
    var high = numbers.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (numbers[mid] < number) {
            low = mid
        } else {
            high = mid
        }
    }
    return high
}

private fun getUpperBound(numbers: List<Int>, number: Int): Int {
    var low = -1
    var high = numbers.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (numbers[mid] > number) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
