package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

/**
 * https://www.acmicpc.net/problem/1925
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val p1 = reader.readLine().split(" ").map { it.toInt() }
    val p2 = reader.readLine().split(" ").map { it.toInt() }
    val p3 = reader.readLine().split(" ").map { it.toInt() }

    val lengthP12 = (p2[0] - p1[0]).toDouble().pow(2).toInt() + (p2[1] - p1[1]).toDouble().pow(2).toInt()
    val lengthP23 = (p3[0] - p2[0]).toDouble().pow(2).toInt() + (p3[1] - p2[1]).toDouble().pow(2).toInt()
    val lengthP31 = (p1[0] - p3[0]).toDouble().pow(2).toInt() + (p1[1] - p3[1]).toDouble().pow(2).toInt()

    if (isX(p1, p2, p3))
        writer.write("X")
    else if (isJungTriangle(lengthP12, lengthP23, lengthP31))
        writer.write("JungTriangle")
    else {
        val signsOfDegree = getSignsOfDegree(p1, p2, p3)

        if (signsOfDegree.any { it < 0 }) {
            writer.write(if (isTwoLengthSame(lengthP12, lengthP23, lengthP31)) "Dunkak2Triangle" else "DunkakTriangle")
        } else if (signsOfDegree.any { it == 0 }) {
            writer.write(if (isTwoLengthSame(lengthP12, lengthP23, lengthP31)) "Jikkak2Triangle" else "JikkakTriangle")
        } else {
            writer.write(if (isTwoLengthSame(lengthP12, lengthP23, lengthP31)) "Yeahkak2Triangle" else "YeahkakTriangle")
        }
    }

    writer.flush()
}

private fun isX(p1: List<Int>, p2: List<Int>, p3: List<Int>): Boolean {
    return if (p1[0] == p2[0] && p2[0] == p3[0] && p3[0] == p1[0])
        true
    else if (p1[1] == p2[1] && p2[1] == p3[1] && p3[1] == p1[1])
        true
    else
        (p2[0] - p1[0]) * (p3[1] - p1[1]) == (p3[0] - p1[0]) * (p2[1] - p1[1])
}

private fun isJungTriangle(lengthP12: Int, lengthP23: Int, lengthP31: Int): Boolean {
    return lengthP12 == lengthP23 && lengthP23 == lengthP31
}

private fun getSignsOfDegree(p1: List<Int>, p2: List<Int>, p3: List<Int>): IntArray {
    val signs = IntArray(3)
    signs[0] = (p2[0] - p1[0]) * (p3[0] - p1[0]) + (p2[1] - p1[1]) * (p3[1] - p1[1])
    signs[1] = (p1[0] - p2[0]) * (p3[0] - p2[0]) + (p1[1] - p2[1]) * (p3[1] - p2[1])
    signs[2] = (p1[0] - p3[0]) * (p2[0] - p3[0]) + (p1[1] - p3[1]) * (p2[1] - p3[1])
    return signs
}

private fun isTwoLengthSame(lengthP12: Int, lengthP23: Int, lengthP31: Int): Boolean {
    return lengthP12 == lengthP23 || lengthP23 == lengthP31 || lengthP31 == lengthP12
}