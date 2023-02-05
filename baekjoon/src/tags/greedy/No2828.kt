package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2828
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val input = reader.readLine().split(' ').map { it.toInt() }
    val basket = intArrayOf(1, input[1])

    var distance = 0
    val numberOfInput = reader.readLine().toInt()
    for (i in 0 until numberOfInput) {
        val position = reader.readLine().toInt()
        if (basket[0] <= position && position <= basket[1])
            continue
        else if (basket[0] > position) {
            val movement = basket[0] - position
            distance += movement
            basket[1] -= movement
            basket[0] -= movement
        } else {
            val movement = position - basket[1]
            distance += movement
            basket[1] += movement
            basket[0] += movement
        }
    }

    writer.write(distance.toString())
    writer.flush()
}
