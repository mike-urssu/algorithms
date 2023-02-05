package level.silver3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1063
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var (king, rock, numberOfInput) = reader.readLine().split(" ")

    repeat(numberOfInput.toInt()) {
        val movement = reader.readLine()
        val kingPosition = getNextPosition(king, movement)
        if (isInBoundary(kingPosition)) {
            if (isOverlapped(kingPosition, rock)) {
                val rockPosition = getNextPosition(rock, movement)
                if (isInBoundary(rockPosition)) {
                    king = kingPosition
                    rock = rockPosition
                }
            } else {
                king = kingPosition
            }
        }
    }

    writer.write("$king\n$rock")
    writer.flush()
}

private fun isInBoundary(position: String) =
    position[0] in 'A'..'H' && position[1].digitToInt() in 1..8

private fun getNextPosition(kingOrBall: String, movement: String): String {
    val position = kingOrBall.toCharArray()
    movement.forEach { char ->
        when (char) {
            'R' -> position[0]++
            'L' -> position[0]--
            'B' -> position[1]--
            'T' -> position[1]++
        }
    }
    return position.concatToString()
}

private fun isOverlapped(king: String, rock: String) =
    king == rock
