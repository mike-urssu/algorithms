package tags.sorting

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
        val numbers = reader.readLine().split(' ').map { it.toInt() }.toIntArray().sorted()
        reader.readLine().toInt()
        val numbers2 = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
        for (number in numbers2) {
            if (binarySearch(numbers, number))
                writer.write("1")
            else
                writer.write("0")
            writer.newLine()
        }

//        reader.readLine().toInt()
//        val numbers = HashSet<Int>()
//        reader.readLine().split(' ').map { numbers.add(it.toInt()) }
//        reader.readLine()
//        val numbers2 = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
//
//        for (number in numbers2) {
//            if (numbers.contains(number))
//                writer.write("1")
//            else
//                writer.write("0")
//            writer.newLine()
//        }
    }
    writer.flush()
}

private fun binarySearch(numbers: List<Int>, number: Int): Boolean {
    if (number !in numbers[0]..numbers[numbers.size - 1])
        return false

    var low = 0
    var high = numbers.size - 1
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (number < numbers[mid])
            high = mid
        else if (number == numbers[mid])
            return true
        else
            low = mid
    }
    return numbers[low] == number || numbers[high] == number
}
