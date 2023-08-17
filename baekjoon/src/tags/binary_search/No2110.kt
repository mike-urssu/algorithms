package tags.binary_search

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2110
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var houses: List<Int>
private lateinit var numbers: Set<Int>

fun main() {
    val (n, c) = reader.readLine().split(" ").map { it.toInt() }
    houses = IntArray(n) { reader.readLine().toInt() }.sorted()
    numbers = houses.toSortedSet()

    var low = 1
    var high = houses.last()
    while (low + 1 < high) {
        val distance = (low + high) / 2
        if (getCount(distance) >= c) {
            low = distance
        } else {
            high = distance
        }
    }

    writer.write("$low")
    writer.flush()
}

private fun getCount(distance: Int): Int {
    var count = 1
    var currentNumber = houses.first()

    while (true) {
        val nextIndex = getNextIndex(currentNumber + distance)
        if (nextIndex == houses.size) {
            break
        }
        currentNumber = houses[nextIndex]
        count++
    }

    return count
}

private fun getNextIndex(number: Int) =
    if (numbers.contains(number)) {
        houses.binarySearch(number)
    } else {
        -houses.binarySearch(number) - 1
    }
