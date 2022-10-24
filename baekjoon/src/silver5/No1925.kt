package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sign

/**
 * https://www.acmicpc.net/problem/1925
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private class Position(
    val x: Int, val y: Int
) {
    constructor(position: List<Int>) : this(position[0], position[1])
}

fun main() {
    val pos1 = (Position(reader.readLine().split(" ").map { it.toInt() }))
    val pos2 = (Position(reader.readLine().split(" ").map { it.toInt() }))
    val pos3 = (Position(reader.readLine().split(" ").map { it.toInt() }))

    if (isX(pos1, pos2, pos3)) {
        writer.write("X")
    } else {
        val ratiosOfCos = getRatiosOfCos(pos1, pos2, pos3)
        val signOfMinCos = ratiosOfCos.minOf { it }.sign
        if (ratiosOfCos.all { it == ratiosOfCos[0] }) {
            writer.write("JungTriangle")
        } else if (ratiosOfCos[0] == ratiosOfCos[1] || ratiosOfCos[1] == ratiosOfCos[2] || ratiosOfCos[2] == ratiosOfCos[0]) {
            when (signOfMinCos) {
                -1 -> {
                    writer.write("Dunkak2Triangle")
                }
                0 -> {
                    writer.write("Jikkak2Triangle")
                }
                else -> {
                    writer.write("Yeahkak2Triangle")
                }
            }
        } else {
            when (signOfMinCos) {
                -1 -> {
                    writer.write("DunkakTriangle")
                }
                0 -> {
                    writer.write("JikkakTriangle")
                }
                else -> {
                    writer.write("YeahkakTriangle")
                }
            }
        }
    }

    writer.flush()
}

private fun isX(pos1: Position, pos2: Position, pos3: Position): Boolean {
    return (pos1.x == pos2.x && pos2.x == pos3.x) || (pos1.y == pos2.y && pos2.y == pos3.y) || (pos2.y - pos1.y) * (pos3.x - pos2.x) == (pos2.x - pos1.x) * (pos3.y - pos2.y)
}

private fun getRatiosOfCos(pos1: Position, pos2: Position, pos3: Position): IntArray {
    val ratiosOfCos = IntArray(3)
    ratiosOfCos[0] = (pos2.x - pos1.x) * (pos3.x - pos1.x) + (pos2.y - pos1.y) * (pos3.y - pos1.y)
    ratiosOfCos[1] = (pos1.x - pos2.x) * (pos3.x - pos2.x) + (pos1.y - pos2.y) * (pos3.y - pos2.y)
    ratiosOfCos[2] = (pos1.x - pos3.x) * (pos2.x - pos3.x) + (pos1.y - pos3.y) * (pos2.y - pos3.y)
    return ratiosOfCos
}