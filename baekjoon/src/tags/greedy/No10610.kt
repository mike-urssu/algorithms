package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10610
 */
val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val number = reader.readLine()

    if (canBeMultipleOf3(number) && number.contains('0'))
        printMultipleOf30(number)
    else {
        writer.write((-1).toString())
        writer.flush()
        return
    }
}

fun canBeMultipleOf3(number: String): Boolean {
    var sum = 0
    for (character in number)
        sum += character.digitToInt()
    return sum % 3 == 0
}

fun printMultipleOf30(number: String) {
    val numbersInCharacter = number.toCharArray().sorted().reversed()
    for (character in numbersInCharacter)
        writer.write(character.toString())
    writer.flush()
}
