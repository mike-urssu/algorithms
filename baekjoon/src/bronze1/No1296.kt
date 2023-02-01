package bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1296
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val name = reader.readLine()
    val numberOfInput = reader.readLine().toInt()

    var winner = ""
    var maxRate = Int.MIN_VALUE
    val candidates = Array(numberOfInput) { reader.readLine() }.sorted()
    candidates.forEach { candidate ->
        val rate = getRate(name, candidate)
        if (rate > maxRate) {
            winner = candidate
            maxRate = rate
        }
    }

    writer.write(winner)
    writer.flush()
}

private fun getRate(name1: String, name2: String): Int {
    val l = name1.count { it == 'L' } + name2.count { it == 'L' }
    val o = name1.count { it == 'O' } + name2.count { it == 'O' }
    val v = name1.count { it == 'V' } + name2.count { it == 'V' }
    val e = name1.count { it == 'E' } + name2.count { it == 'E' }
    return ((l + o) * (l + v) * (l + e) * (o + v) * (o + e) * (v + e)) % 100
}
