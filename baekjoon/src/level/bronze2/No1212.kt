package level.bronze2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1212
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val octal = reader.readLine()
    if (octal == "0") {
        writer.write("0")
    } else {
        writer.write(octalToBinary(octal))
    }
    writer.flush()
}

private fun octalToBinary(octal: String): String {
    val binary = StringBuilder()
    octal.forEach { binary.append(octalToBinary(it)) }
    val index = binary.toString().indexOf("1")
    return binary.substring(index)
}

private fun octalToBinary(o: Char): String {
    return when (o) {
        '0' -> "000"
        '1' -> "001"
        '2' -> "010"
        '3' -> "011"
        '4' -> "100"
        '5' -> "101"
        '6' -> "110"
        '7' -> "111"
        else -> {
            ""
        }
    }
}
