package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.ceil
import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/2312
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val countOfFactor = sortedMapOf<Int, Int>()

        var number = reader.readLine().toInt()
        val sqrt = ceil(sqrt(number.toDouble())).toInt()

        var factor = 2
        while (factor <= sqrt) {
            if (number % factor == 0) {
                countOfFactor[factor] = countOfFactor.getOrDefault(factor, 0) + 1
                number /= factor
            } else {
                factor++
            }
        }

        if (number != 1)
            countOfFactor[number] = countOfFactor.getOrDefault(number, 0) + 1

        for (key in countOfFactor.keys)
            writer.write("$key ${countOfFactor[key]}\n")
    }
    writer.flush()
}