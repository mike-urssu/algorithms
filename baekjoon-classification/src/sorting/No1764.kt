package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1764
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numbers = reader.readLine().split(' ').map { it.toInt() }
    val names = HashSet<String>()
    for (i in 0 until numbers[0]) {
        val name = reader.readLine()
        names.add(name)
    }

    var count = 0
    val unknownNames = arrayListOf<String>()
    for (i in 0 until numbers[1]) {
        val name = reader.readLine()
        if (names.contains(name)) {
            unknownNames.add(name)
            count++
        }
    }
    unknownNames.sort()

    writer.write(count.toString())
    writer.newLine()
    for (name in unknownNames) {
        writer.write(name)
        writer.newLine()
    }
    writer.flush()
}
