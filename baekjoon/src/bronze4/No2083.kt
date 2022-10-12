package bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2083
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    while (true) {
        val memberInfo = reader.readLine().split(" ")
        if (memberInfo == listOf("#", "0", "0")) {
            break
        }
        if (memberInfo[1].toInt() > 17 || memberInfo[2].toInt() >= 80) {
            writer.write("${memberInfo[0]} Senior\n")
        } else {
            writer.write("${memberInfo[0]} Junior\n")
        }
    }
    writer.flush()
}