package level.bronze5

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/14581
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    println(
        """
        :fan::fan::fan:
        :fan::${reader.readLine()}::fan:
        :fan::fan::fan:
    """.trimIndent()
    )
}
