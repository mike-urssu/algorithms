package level.bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2754
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    when (reader.readLine()) {
        "A+" -> writer.write("4.3")
        "A0" -> writer.write("4.0")
        "A-" -> writer.write("3.7")
        "B+" -> writer.write("3.3")
        "B0" -> writer.write("3.0")
        "B-" -> writer.write("2.7")
        "C+" -> writer.write("2.3")
        "C0" -> writer.write("2.0")
        "C-" -> writer.write("1.7")
        "D+" -> writer.write("1.3")
        "D0" -> writer.write("1.0")
        "D-" -> writer.write("0.7")
        "F" -> writer.write("0.0")
    }
    writer.flush()
}