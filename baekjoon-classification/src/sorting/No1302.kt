package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1302
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val titles = HashMap<String, Int>()
    for (i in 0 until numberOfInput) {
        val title = reader.readLine()
        titles[title] = titles.getOrDefault(title, 0) + 1
    }

    var title = ""
    var maxCount = 0
    for (key in titles.keys) {
        val count = titles[key]!!
        if (count > maxCount) {
            maxCount = count
            title = key
        } else if (count == maxCount && title > key)
            title = key
    }
    writer.write(title)
    writer.flush()
}
