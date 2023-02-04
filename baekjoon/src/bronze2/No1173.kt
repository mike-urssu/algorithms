package bronze2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1173
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (N, m, M, T, R) = reader.readLine().split(" ").map { it.toInt() }
    var currentPulse = m
    var exerciseMinutes = 0
    var minutes = 0

    if (currentPulse + T > M && currentPulse - R < m) {
        minutes = -1
    } else {
        while (exerciseMinutes < N) {
            if (currentPulse + T <= M) {
                currentPulse += T
                exerciseMinutes++
                minutes++
            } else {
                currentPulse = (currentPulse - R).coerceAtLeast(m)
                minutes++
            }
        }
    }

    writer.write("$minutes")
    writer.flush()
}
