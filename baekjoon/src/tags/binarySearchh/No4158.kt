package tags.binarySearchh

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/4158
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    while (true) {
        val (n, m) = reader.readLine().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) {
            break
        }

        val cd1 = List(n) { reader.readLine().toInt() }
        val cd2 = List(m) { reader.readLine().toInt() }

        val count = cd2.count { cd1.binarySearch(it) >= 0 }
        writer.write("$count\n")
    }
    writer.flush()
}
