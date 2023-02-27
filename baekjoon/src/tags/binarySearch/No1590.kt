package tags.binarySearch

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1590
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, t) = reader.readLine().split(" ").map { it.toInt() }
    val waitTimeouts = mutableListOf<Int>()
    repeat(n) {
        val (s, l, c) = reader.readLine().split(" ").map { it.toInt() }
        for (i in 0 until c) {
            waitTimeouts.add(s + l * i)
        }
    }
    waitTimeouts.sort()

    if (waitTimeouts.contains(t)) {
        writer.write("0")
    } else {
        val index = -waitTimeouts.binarySearch(t) - 1
        if (index == waitTimeouts.size) {
            writer.write("-1")
        } else {
            writer.write("${waitTimeouts[index] - t}")
        }
    }
    writer.flush()
}
