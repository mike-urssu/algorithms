package bronze3

/**
 * https://www.acmicpc.net/problem/1598
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (from, to) = reader.readLine().split(" ").map { it.toInt() }
    writer.write("${getDistance(from, to)}")
    writer.flush()
}

private fun getDistance(from: Int, to: Int): Int {
    val position1 = getPosition(from)
    val position2 = getPosition(to)
    return abs(position1[0] - position2[0]) + abs(position1[1] - position2[1])
}

private fun getPosition(number: Int) = intArrayOf((number - 1) % 4, (number - 1) / 4)
