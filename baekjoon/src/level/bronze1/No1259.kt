package level.bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1259
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    while (true) {
        val number = reader.readLine()
        if (number == "0") {
            break
        }

        var isPalindrome = true
        val length = number.length
        for (i in 0 until length / 2) {
            if (number[i] != number[length - 1 - i]) {
                isPalindrome = false
                break
            }
        }

        if (isPalindrome) {
            writer.write("yes\n")
        } else {
            writer.write("no\n")
        }
    }
    writer.flush()
}