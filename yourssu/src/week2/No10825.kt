package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10825
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    val grades = mutableListOf<Grade>()
    repeat(numberOfInput) {
        val input = reader.readLine().split(" ")
        grades.add(Grade(input[0], input[1].toInt(), input[2].toInt(), input[3].toInt()))
    }

    grades.sortedWith { grade1, grade2 ->
        if (grade1.korean == grade2.korean) {
            if (grade1.english == grade2.english) {
                if (grade1.math == grade2.math)
                    grade1.name.compareTo(grade2.name)
                else
                    -(grade1.math - grade2.math)
            } else
                grade1.english - grade2.english
        } else
            -(grade1.korean - grade2.korean)
    }.forEach { grade ->
        writer.write(grade.name)
        writer.newLine()
    }
    writer.flush()
}

private class Grade(
    val name: String, val korean: Int, val english: Int, val math: Int
)