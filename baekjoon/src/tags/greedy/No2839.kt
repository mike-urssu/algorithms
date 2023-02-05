package tags.greedy

import java.io.*

/**
 * https://www.acmicpc.net/problem/2839
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val sugar = reader.readLine().toInt()
    writer.write(getBags(sugar).toString())
    writer.flush()
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
