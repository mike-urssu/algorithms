package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

/**
 * https://www.acmicpc.net/problem/2535
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private class Info(info: List<Int>) {
    var country: Int = 0
    var index: Int = 0
    var score: Int = 0

    init {
        country = info[0]
        index = info[1]
        score = info[2]
    }
}

fun main() {
    val infos = PriorityQueue<Info> { it, other -> -it.score.compareTo(other.score) }

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val info = Info(reader.readLine().split(" ").map { it.toInt() })
        infos.add(info)
    }

    var count = 3
    val countries = mutableMapOf<Int, Int>()
    while (count > 0) {
        val info = infos.poll()
        if (countries.getOrDefault(info.country, 0) < 2) {
            writer.write("${info.country} ${info.index}\n")
            countries[info.country] = countries.getOrDefault(info.country, 0) + 1
            count--
        }
    }
    writer.flush()
}