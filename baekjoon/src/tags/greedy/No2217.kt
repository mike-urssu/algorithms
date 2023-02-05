package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2217
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val ropes = IntArray(numberOfInput)
    for (i in 0 until numberOfInput)
        ropes[i] = reader.readLine().toInt()
    ropes.sort()

    var max = Integer.MIN_VALUE
    for (i in ropes.indices) {
        var count = 0
        for (j in i until ropes.size) {
            if (ropes[i] <= ropes[j])
                count++
        }
        max = Math.max(max, ropes[i] * count)
    }

    writer.write(max.toString())
    writer.flush()
}
