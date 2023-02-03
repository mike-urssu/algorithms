package bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1268
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfStudent = reader.readLine().toInt()
    val classes = Array<IntArray>(numberOfStudent) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val students = MutableList(numberOfStudent) { sortedSetOf<Int>() }
    repeat(5) { c ->
        for (i in 0 until numberOfStudent) {
            for (j in 0 until numberOfStudent) {
                if (i != j && classes[i][c] == classes[j][c]) {
                    students[i].add(j)
                }
            }
        }
    }

    writer.write("${students.indexOfFirst { s -> s.size == students.maxOf { it.size } } + 1}")
    writer.flush()
}
