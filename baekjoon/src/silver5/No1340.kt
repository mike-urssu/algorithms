package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.concurrent.TimeUnit

/**
 * https://www.acmicpc.net/problem/1340
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private val months = arrayOf(
    "-",
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
)

private val days = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

fun main() {
    val now = reader.readLine().split(", ", " ", ":")
    writer.write("${getCurrentMinutes(now) * 100.0 / getTotalMinutes(now[2].toInt())}")
    writer.flush()
}

private fun getCurrentMinutes(now: List<String>): Long {
    var minutes = 0L
    minutes += TimeUnit.MINUTES.toMinutes(now[4].toLong())
    minutes += TimeUnit.HOURS.toMinutes(now[3].toLong())
    minutes += TimeUnit.DAYS.toMinutes(getDays(now[2].toInt(), months.indexOf(now[0]), now[1].toInt() - 1))
    return minutes
}

private fun getDays(year: Int, month: Int, day: Int): Long {
    var d = day.toLong()
    for (i in 0 until month) {
        d += days[i]
    }
    if (isLeapYear(year) && month > 2) {
        d++
    }
    return d
}

private fun getTotalMinutes(year: Int): Long {
    var date = 365
    if (isLeapYear(year)) {
        date++
    }
    return TimeUnit.DAYS.toMinutes(date.toLong())
}

private fun isLeapYear(year: Int) = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0