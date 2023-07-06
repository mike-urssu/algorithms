package tags.bruteforcing

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1233
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (s1, s2, s3) = reader.readLine().split(" ").map { it.toInt() }
    val counts = mutableMapOf<Int, Int>()
    for (i in 1..s1) {
        for (j in 1..s2) {
            for (k in 1..s3) {
                val sum = i + j + k
                counts[sum] = counts.getOrDefault(sum, 0) + 1
            }
        }
    }

    writer.write("${counts.entries.maxBy { it.value }.key}")
    writer.flush()
}
