package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11557
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val numberOfInput = reader.readLine().toInt()
        var max = Int.MIN_VALUE
        var name = ""
        for (i in 0 until numberOfInput) {
            val school = reader.readLine().split(' ')
            val drink = school[1].toInt()
            if (drink > max) {
                max = drink
                name = school[0]
            }
        }
        writer.write(name)
        writer.newLine()
    }
    writer.flush()
}
