package dataStructure

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

    val inputs = reader.readLine().split(" ").map { it.toInt() }

    val neverHeard = mutableSetOf<String>()
    repeat(inputs[0]) {
        neverHeard.add(reader.readLine())
    }

    val neverHeardAndSeen = mutableListOf<String>()
    repeat(inputs[1]) {
        val name = reader.readLine()
        if (neverHeard.contains(name))
            neverHeardAndSeen.add(name)
    }
    neverHeardAndSeen.sort()

    writer.write("${neverHeardAndSeen.size}")
    writer.newLine()
    for (name in neverHeardAndSeen) {
        writer.write(name)
        writer.newLine()
    }
    writer.flush()
}
