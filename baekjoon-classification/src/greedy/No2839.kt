package greedy

import java.io.*

/**
 * https://www.acmicpc.net/problem/2839
 */
fun main() {
    val sugar = readLine().toInt()
    write(getBags(sugar).toString())
}

fun getBags(sugar: Int): Int {
    var bags = 0
    for (fiveKgBag in sugar / 5 downTo 0) {
        if ((sugar - 5 * fiveKgBag) % 3 == 0) {
            bags += fiveKgBag
            bags += (sugar - 5 * fiveKgBag) / 3
            return bags
        }
    }
    return -1
}

fun readLine(): String {
    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        return reader.readLine()
    }
}

fun write(text: Any) {
    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write(text.toString())
        writer.newLine()
        writer.flush()
    }
}
