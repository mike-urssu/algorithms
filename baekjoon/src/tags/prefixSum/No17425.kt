package tags.prefixSum

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/17425
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val f = LongArray(1000001)
    for (i in 1..1000000) {
        for (j in i..1000000 step i) {
            f[j] += i.toLong()
        }
    }

    val g = LongArray(1000001)
    (1..1000000).forEach { i -> g[i] = g[i - 1] + f[i] }

    val t = reader.readLine().toInt()
    repeat(t) {
        val n = reader.readLine().toInt()
        writer.write("${g[n]}\n")
    }
    writer.flush()
}
