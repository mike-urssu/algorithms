package week3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.SortedSet
import java.util.TreeSet

/**
 * https://www.acmicpc.net/problem/7785
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val names: SortedSet<String> = TreeSet { it, other -> -it.compareTo(other) }

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val input = reader.readLine().split(" ")
        val name = input[0]
        val command = input[1]

        if (command == "enter")
            names.add(name)
        else
            names.remove(name)
    }

    names.forEach { name -> writer.write("$name\n") }
    writer.flush()
}