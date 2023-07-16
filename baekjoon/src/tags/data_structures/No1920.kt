package tags.data_structures

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1920
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val set = HashSet<String>()

    reader.readLine()
    reader.readLine().split(" ").map { set.add(it) }
    reader.readLine()
    reader.readLine().split(" ").map {
        writer.write("${if (set.contains(it)) 1 else 0}")
        writer.newLine()
    }
    writer.flush()
}
