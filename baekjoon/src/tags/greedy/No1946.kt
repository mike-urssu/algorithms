package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1946
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    for (i in 0 until numberOfInput) {
        val employees = reader.readLine().toInt()
        val rankings = arrayListOf<IntArray>()
        for (j in 0 until employees)
            rankings.add(reader.readLine().split(' ').map { it.toInt() }.toIntArray())
        writer.write(getMaxEmployees(rankings).toString())
        writer.newLine()
    }
    writer.flush()
}

fun getMaxEmployees(rankings: List<IntArray>): Int {
    var employeesCount = rankings.size
    val sortedRankings = rankings.sortedWith(compareBy { it[0] })
    var min = sortedRankings[0][1]
    for (i in 1 until sortedRankings.size) {
        if (sortedRankings[i][1] > min)
            employeesCount--
        else
            min = sortedRankings[i][1]
    }
    return employeesCount
}
