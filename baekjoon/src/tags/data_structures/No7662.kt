package tags.data_structures

/**
 * https://www.acmicpc.net/problem/7662
 */
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.SortedMap

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val t = reader.readLine().toInt()
    repeat(t) {
        val numbers = sortedMapOf<Int, Int>()
        val k = reader.readLine().toInt()
        repeat(k) {
            val commands = reader.readLine().split(" ")
            val command = commands[0]
            val n = commands[1].toInt()

            if (command == "I") {
                insert(numbers, n)
            } else {
                if (numbers.isNotEmpty()) {
                    drop(numbers, n)
                }
            }
        }

        if (numbers.isEmpty()) {
            println("EMPTY")
        } else {
            println("${numbers.lastKey()} ${numbers.firstKey()}")
        }
    }
}

private fun insert(numbers: SortedMap<Int, Int>, n: Int) {
    numbers[n] = (numbers[n] ?: 0) + 1
}

private fun drop(numbers: SortedMap<Int, Int>, n: Int) {
    val number = if (n == 1) {
        numbers.lastKey()
    } else {
        numbers.firstKey()
    }

    numbers[number] = numbers[number]!! - 1
    if (numbers[number] == 0) {
        numbers.remove(number)
    }
}
