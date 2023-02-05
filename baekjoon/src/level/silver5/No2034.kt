package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2034
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private val pitches = intArrayOf(0, 2, 3, 5, 7, 8, 10)
private val pitchesAsChar = charArrayOf('A', '-', 'B', 'C', '-', 'D', '-', 'E', 'F', '-', 'G', '-', 'A')

fun main() {
    val numberOfInput = reader.readLine().toInt()
    val indices = IntArray(numberOfInput) { reader.readLine().toInt() % 12 }

    for (pitch in pitches) {
        var isValid = true
        var currentPitch = pitch
        for (index in indices) {
            currentPitch = (currentPitch + index + 12) % 12
            if (!pitches.contains(currentPitch)) {
                isValid = false
                break
            }
        }

        if (isValid) {
            writer.write("${pitchesAsChar[pitch]} ${pitchesAsChar[currentPitch]}\n")
        }
    }

    writer.flush()
}