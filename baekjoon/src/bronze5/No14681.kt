package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/14681
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val x = reader.readLine().toInt()
    val y = reader.readLine().toInt()

    if (x > 0) {
        if (y > 0) {
            writer.write("1")
        } else {
            writer.write("4")
        }
    } else {
        if (y > 0) {
            writer.write("2")
        } else {
            writer.write("3")
        }
    }
    writer.flush()
}