package silver5

/**
 * https://www.acmicpc.net/problem/1064
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow
import kotlin.math.sqrt

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val pos1 = Pair(numbers[0], numbers[1])
    val pos2 = Pair(numbers[2], numbers[3])
    val pos3 = Pair(numbers[4], numbers[5])

    if (areThreePointsAtOneLine(pos1, pos2, pos3)) {
        writer.write("-1")
    } else {
        val lengths = getLengths(pos1, pos2, pos3)
        writer.write("${(lengths[2] - lengths[0]) * 2}")
    }
    writer.flush()
}

private fun areThreePointsAtOneLine(pos1: Pair<Int, Int>, pos2: Pair<Int, Int>, pos3: Pair<Int, Int>) =
    (pos2.second - pos1.second) * (pos3.first - pos2.first) == (pos3.second - pos2.second) * (pos2.first - pos1.first)

private fun getLengths(pos1: Pair<Int, Int>, pos2: Pair<Int, Int>, pos3: Pair<Int, Int>): Array<Double> {
    val length1 = getLength(pos1, pos2)
    val length2 = getLength(pos2, pos3)
    val length3 = getLength(pos3, pos1)
    return arrayOf(length1, length2, length3).sortedArray()
}

private fun getLength(pos1: Pair<Int, Int>, pos2: Pair<Int, Int>) =
    sqrt((pos2.first - pos1.first).toDouble().pow(2) + (pos2.second - pos1.second).toDouble().pow(2))
