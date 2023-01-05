package bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1057
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var (_, kim, im) = reader.readLine().split(" ").map { it.toInt() }
    var count = 0

    while (kim != im) {
        kim = (kim + 1) / 2
        im = (im + 1) / 2
        count++
    }

    writer.write("$count")
    writer.flush()
}
