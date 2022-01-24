package greedy

/**
 * https://www.acmicpc.net/problem/1783
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val input = reader.readLine().split(' ').map { it.toInt() }
    val row = input[0]
    val col = input[1]

    val count =
        if (row == 1) 1
        else if (row == 2) 4.coerceAtMost((col + 1) / 2)
        else if (col < 7) 4.coerceAtMost(col)
        else col - 2
    writer.write(count.toString())
    writer.flush()
}
