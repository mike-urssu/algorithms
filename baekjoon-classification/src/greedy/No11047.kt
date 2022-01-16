package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/11047
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val input = StringTokenizer(reader.readLine())
    val unitCount = input.nextToken().toInt()
    val units = arrayListOf<Int>()
    for (i in 0 until unitCount)
        units.add(reader.readLine().toInt())
    units.reverse()

    var money = input.nextToken().toInt()
    var count = 0
    for (unit in units) {
        count += money / unit
        money %= unit
    }

    writer.write(count.toString())
    writer.flush()
}
