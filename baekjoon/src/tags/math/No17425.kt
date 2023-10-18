package tags.math

/**
 * https://www.acmicpc.net/problem/17425
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val g = g()

    val t = reader.readLine().toInt()
    repeat(t) {
        val n = reader.readLine().toInt()
        writer.write("${g[n]}\n")
    }
    writer.flush()
}

private fun g(): List<Long> {
    val f = getF()
    return f.runningFold(0, Long::plus).drop(1)
}

private fun getF(): IntArray {
    val f = IntArray(1000001)
    for (i in 1..1000000) {
        for (j in i..1000000 step i) {
            f[j] += i
        }
    }
    return f
}
