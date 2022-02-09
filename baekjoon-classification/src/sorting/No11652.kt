package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11652
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val countOfNumber = HashMap<Long, Int>()
    for (i in 0 until numberOfInput) {
        val number = reader.readLine().toLong()
        countOfNumber[number] = countOfNumber.getOrDefault(number, 0) + 1
    }

    var maxCount = 0
    var maxNumber = Long.MAX_VALUE
    for (key in countOfNumber.keys) {
        val count = countOfNumber[key]!!
        if (count > maxCount) {
            maxCount = count
            maxNumber = key
        } else if (count == maxCount && maxNumber > key)
            maxNumber = key
    }

    writer.write(maxNumber.toString())
    writer.flush()
}
