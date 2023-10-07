package tags.binary_search

/**
 * https://www.acmicpc.net/problem/19637
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val names = mutableListOf<String>()
    val numbers = mutableListOf<Int>()
    repeat(n) {
        val (name, number) = reader.readLine().split(" ")
        if ((numbers.lastOrNull() ?: -1) != number.toInt()) {
            names.add(name)
            numbers.add(number.toInt())
        }
    }

    repeat(m) {
        val number = reader.readLine().toInt()
        writer.write("${getName(names, numbers, number)}\n")
    }
    writer.flush()
}

private fun getName(names: List<String>, numbers: List<Int>, number: Int): String {
    var low = -1
    var high = names.size
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (numbers[mid] >= number) {
            high = mid
        } else {
            low = mid
        }
    }
    return names[high]
}
