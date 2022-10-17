package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.SortedSet
import java.util.TreeSet

/**
 * https://www.acmicpc.net/problem/1331
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val movements = arrayOf(
        Pair(-2, 1),
        Pair(-1, 2),
        Pair(1, 2),
        Pair(2, 1),
        Pair(2, -1),
        Pair(1, -2),
        Pair(-1, -2),
        Pair(-2, -1)
    )

    val distinctPositions: SortedSet<String> = TreeSet()
    val positions = Array(36) {
        val position = reader.readLine()
        distinctPositions.add(position)
        Pair(position[0] - 'A', position[1].digitToInt())
    }

    var isMovementValid = true
    if (distinctPositions.size != 36) {
        isMovementValid = false
    } else {
        for (i in positions.indices) {
            val currentPosition = positions[i]
            val nextPosition = positions[(i + 1) % 36]
            val movement =
                Pair(nextPosition.first - currentPosition.first, nextPosition.second - currentPosition.second)
            if (!movements.contains(movement)) {
                isMovementValid = false
                break
            }
        }
    }

    if (isMovementValid) {
        writer.write("Valid")
    } else {
        writer.write("Invalid")
    }
    writer.flush()
}