package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1340
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private val months = mutableMapOf<String, Int>()
private val days = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

fun main() {
    setMonths()

    val date = reader.readLine()
    val month = date.split(",")[0].split(" ")[0]
    val day = date.split(",")[0].split(" ")[1].toInt()
    val year = date.split(" ")[2].toInt()
    val hourAndMinute = date.split(" ")[3].split(":").map { it.toInt() }

    if (isLeapYear(year)) days[months["February"]!!]++

    val minutesOfYear = days.sum() * 24 * 60
    val minutes = getMinutes(month, day, hourAndMinute)

    writer.write("${minutes.toDouble() * 100 / minutesOfYear}")
    writer.flush()
}

private fun setMonths() {
    arrayOf(
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    ).forEachIndexed { index, name -> months[name] = index + 1 }
}

private fun isLeapYear(year: Int): Boolean {
    return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)
}

private fun getMinutes(month: String, day: Int, hourAndMinute: List<Int>): Int {
    var minutes = 0

    var sumOfDays = 0
    for (i in 1 until months[month]!!)
        sumOfDays += days[i]
    sumOfDays += (day - 1)
    minutes += sumOfDays * 24 * 60 + hourAndMinute[0] * 60 + hourAndMinute[1]

    return minutes
}