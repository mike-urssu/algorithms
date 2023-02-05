package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1969
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (numberOfInput, length) = reader.readLine().split(" ").map { it.toInt() }
    val dnaList = Array<String>(numberOfInput) { reader.readLine() }

    val answer = StringBuilder()
    for (i in 0 until length) {
        val components = sortedMapOf<Char, Int>()
        dnaList.forEach { dna ->
            components[dna[i]] = components.getOrDefault(dna[i], 0) + 1
        }

        var value = '-'
        var max = Int.MIN_VALUE
        components.forEach { (k, v) ->
            if (max < v) {
                value = k
                max = v
            }
        }
        answer.append(value)
    }

    var hammingDistance = 0
    dnaList.forEach { dna ->
        for (i in dna.indices) {
            if (answer[i] != dna[i]) {
                hammingDistance++
            }
        }
    }

    writer.write("$answer\n")
    writer.write("$hammingDistance\n")
    writer.flush()
}
