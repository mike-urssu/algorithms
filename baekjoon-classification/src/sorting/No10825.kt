package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10825
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val students = arrayListOf<List<String>>()
    for (i in 0 until numberOfInput) {
        val student = reader.readLine().split(' ')
        students.add(student)
    }

    val comparator: Comparator<List<String>> = Comparator { it, other ->
        val itScores = it.subList(1, it.size).map { it.toInt() }
        val otherScores = other.subList(1, other.size).map { it.toInt() }
        if (itScores[0] == otherScores[0]) {
            if (itScores[1] == otherScores[1]) {
                if (itScores[2] == otherScores[2])
                    it[0].compareTo(other[0])
                else
                    -(itScores[2] - otherScores[2])
            } else
                itScores[1] - otherScores[1]
        } else
            -(itScores[0] - otherScores[0])
    }

    students.sortWith(comparator)

    for (student in students) {
        writer.write(student[0])
        writer.newLine()
    }
    writer.flush()
}
