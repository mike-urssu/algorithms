package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/20529
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val numberOfInput = reader.readLine().toInt()
        if (numberOfInput > 32) {
            reader.readLine()
            writer.write("0\n")
        } else {
            val mbtiTypes = reader.readLine().split(" ")
            writer.write("${getMinimumMBTIDistance(mbtiTypes)}\n")
        }
    }
    writer.flush()
}

private fun getMinimumMBTIDistance(mbtiTypes: List<String>): Int {
    var min = Int.MAX_VALUE

    for (i in 0 until mbtiTypes.size - 2) {
        for (j in i + 1 until mbtiTypes.size - 1) {
            for (k in j + 1 until mbtiTypes.size) {
                val distance = getDistance(mbtiTypes[i], mbtiTypes[j]) +
                        getDistance(mbtiTypes[j], mbtiTypes[k]) +
                        getDistance(mbtiTypes[k], mbtiTypes[i])
                min = min.coerceAtMost(distance)
            }
        }
    }

    return min
}

private fun getDistance(mbti1: String, mbti2: String): Int {
    var distance = 0
    for (i in 0..3) {
        if (mbti1[i] != mbti2[i])
            distance++
    }
    return distance
}