package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

/**
 * https://www.acmicpc.net/problem/1343
 */
fun main() {
    val polyomino = reader.readLine().replace("XXXX", "AAAA").replace("XX", "BB")
    if (polyomino.contains("X")) {
        writer.write("-1")
    } else {
        writer.write(polyomino)
    }
    writer.flush()
}