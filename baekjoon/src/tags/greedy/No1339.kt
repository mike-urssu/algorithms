package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

/**
 * https://www.acmicpc.net/problem/1339
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val words = mutableListOf<String>()
    val numberOfInput = reader.readLine().toInt()
    for (i in 0 until numberOfInput)
        words.add(reader.readLine().reversed())

    writer.write(getMax(words).toString())
    writer.flush()
}

fun getMax(words: List<String>): Int {
    val numbers = IntArray(26)
    for (word in words) {
        for (i in word.indices)
            numbers[word[i] - 'A'] += (10.0).pow(i).toInt()
    }

    var decrement = 9
    var sum = 0
    for (number in numbers.sorted().reversed())
        sum += number * decrement--
    return sum
}
