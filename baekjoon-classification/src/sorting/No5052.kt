package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5052
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val testCase = reader.readLine().toInt()
    for (i in 0 until testCase) {
        val phoneAddresses = arrayListOf<String>()
        val numberOfInput = reader.readLine().toInt()
        for (j in 0 until numberOfInput) {
            val phoneAddress = reader.readLine()
            phoneAddresses.add(phoneAddress)
        }
        phoneAddresses.sort()

        writer.write(if (isConsistent(phoneAddresses)) "YES" else "NO")
        writer.newLine()
    }
    writer.flush()
}

private fun isConsistent(phoneAddresses: List<String>): Boolean {
    for (i in 0 until phoneAddresses.size - 1) {
        if (phoneAddresses[i + 1].startsWith(phoneAddresses[i]))
            return false
    }
    return true
}
