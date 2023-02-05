package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1384
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var index = 1
    while (true) {
        val numberOfInput = reader.readLine().toInt()
        if (numberOfInput == 0) {
            break
        }
        writer.write("Group ${index++}\n")

        val names = mutableListOf<String>()
        val messages = mutableListOf<List<String>>()
        repeat(numberOfInput) {
            val line = reader.readLine().split(" ")
            names.add(line[0])
            messages.add(line.subList(1, numberOfInput))
        }

        var isNegativeMessageExist = false
        for (i in messages.indices) {
            for (j in messages[i].indices) {
                if (messages[i][j] == "N") {
                    isNegativeMessageExist = true
                    writer.write("${names[(i + (numberOfInput - 1) - j) % numberOfInput]} was nasty about ${names[i]}\n")
                }
            }
        }

        if (!isNegativeMessageExist) {
            writer.write("Nobody was nasty\n")
        }
        writer.newLine()
    }
    writer.flush()
}