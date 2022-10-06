package bronze2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1076
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val resistances = mapOf(
        Pair("black", 0),
        Pair("brown", 1),
        Pair("red", 2),
        Pair("orange", 3),
        Pair("yellow", 4),
        Pair("green", 5),
        Pair("blue", 6),
        Pair("violet", 7),
        Pair("grey", 8),
        Pair("white", 9)
    )

    var resistance = 0L
    resistance += resistances[reader.readLine()]!!
    resistance = resistance * 10 + resistances[reader.readLine()]!!
    repeat(resistances[reader.readLine()]!!) {
        resistance = resistance.times(10)
    }

    writer.write("$resistance")
    writer.flush()
}