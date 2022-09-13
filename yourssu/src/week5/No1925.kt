package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1925
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val p1 = reader.readLine().split(" ").map { it.toInt() }
    val p2 = reader.readLine().split(" ").map { it.toInt() }
    val p3 = reader.readLine().split(" ").map { it.toInt() }

    val ratioOfCos = getRatioOfCos(p1, p2, p3)

    if (isX(p1, p2, p3))
        writer.write("X")
    else if (isJungTriangle(ratioOfCos))
        writer.write("JungTriangle")
    else {
        if (ratioOfCos.any { it < 0 })
            writer.write(if (isTwoRatioOfCosSame(ratioOfCos)) "Dunkak2Triangle" else "DunkakTriangle")
        else if (ratioOfCos.any { it == 0 })
            writer.write(if (isTwoRatioOfCosSame(ratioOfCos)) "Jikkak2Triangle" else "JikkakTriangle")
        else
            writer.write(if (isTwoRatioOfCosSame(ratioOfCos)) "Yeahkak2Triangle" else "YeahkakTriangle")
    }

    writer.flush()
}

private fun getRatioOfCos(p1: List<Int>, p2: List<Int>, p3: List<Int>): IntArray {
    val signs = IntArray(3)
    signs[0] = (p2[0] - p1[0]) * (p3[0] - p1[0]) + (p2[1] - p1[1]) * (p3[1] - p1[1])
    signs[1] = (p1[0] - p2[0]) * (p3[0] - p2[0]) + (p1[1] - p2[1]) * (p3[1] - p2[1])
    signs[2] = (p1[0] - p3[0]) * (p2[0] - p3[0]) + (p1[1] - p3[1]) * (p2[1] - p3[1])
    return signs
}

private fun isX(p1: List<Int>, p2: List<Int>, p3: List<Int>): Boolean {
    return if (p1[0] == p2[0] && p2[0] == p3[0] && p3[0] == p1[0])
        true
    else if (p1[1] == p2[1] && p2[1] == p3[1] && p3[1] == p1[1])
        true
    else
        (p2[0] - p1[0]) * (p3[1] - p1[1]) == (p3[0] - p1[0]) * (p2[1] - p1[1])
}

private fun isJungTriangle(ratioOfCos: IntArray): Boolean {
    return ratioOfCos[0] == ratioOfCos[1] && ratioOfCos[1] == ratioOfCos[2]
}

private fun isTwoRatioOfCosSame(ratioOfCos: IntArray): Boolean {
    return ratioOfCos[0] == ratioOfCos[1] || ratioOfCos[1] == ratioOfCos[2] || ratioOfCos[2] == ratioOfCos[0]
}