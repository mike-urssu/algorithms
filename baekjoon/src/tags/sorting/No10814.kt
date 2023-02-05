package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10814
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val members = arrayListOf<Array<String>>()
    for (i in 0 until numberOfInput) {
        val member = reader.readLine().split(' ').toTypedArray()
        members.add(member)
    }
    members.sortWith(compareBy { it[0].toInt() })

    for (member in members) {
        writer.write("${member[0]} ${member[1]}")
        writer.newLine()
    }
    writer.flush()
}
