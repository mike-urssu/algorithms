package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val givenWord = reader.readLine()

    for (character in givenWord) {
        writer.write(
            if (character.code in 'A'.code..'Z'.code)
                character.lowercaseChar().toString()
            else
                character.uppercaseChar().toString()
        )
    }

    writer.flush()
}