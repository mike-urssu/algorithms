package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1308
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private val months = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

fun main() {
    val date1 = reader.readLine().split(" ").map { it.toInt() }
    val date2 = reader.readLine().split(" ").map { it.toInt() }

    if (date1[0] + 1000 < date2[0]) {
        writer.write("gg")
    } else if (date1[0] + 1000 == date2[0] && (date1[1] < date2[1] || (date1[1] == date2[1] && date1[2] <= date2[2]))) {
        writer.write("gg")
    } else {
        writer.write("D-${getDDay(date1, date2)}")
    }
    writer.flush()
}

private fun getDDay(date1: List<Int>, date2: List<Int>): Int {
    var sumOfDays1 = 0
    for (i in 1 until date1[1]) {
        sumOfDays1 += months[i]
    }
    sumOfDays1 += date1[2]
    if (isLeapYear(date1[0]) && date1[1] > 2) {
        sumOfDays1++
    }

    var sumOfDays2 = 0
    for (year in date1[0] until date2[0]) {
        sumOfDays2 += if (isLeapYear(year)) {
            366
        } else {
            365
        }
    }
    for (i in 1 until date2[1]) {
        sumOfDays2 += months[i]
    }
    sumOfDays2 += date2[2]
    if (isLeapYear(date2[0]) && date2[1] > 2) {
        sumOfDays2++
    }

    return sumOfDays2 - sumOfDays1
}

private fun isLeapYear(year: Int) = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)