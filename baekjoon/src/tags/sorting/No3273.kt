package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/3273
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val numbers = reader.readLine().split(' ').map { it.toInt() }.sorted()
    val target = reader.readLine().toInt()

    var count = 0
    var i = 0
    var j = numbers.size - 1
    while (i < j) {
        val sum = numbers[i] + numbers[j]
        if (sum == target) {
            i++
            j--
            count++
        } else if (target < sum)
            j--
        else
            i++
    }

    writer.write(count.toString())
    writer.flush()
}
