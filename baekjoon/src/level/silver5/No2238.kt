package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2238
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().split(" ").map { it.toInt() }[1]

    val prices = sortedMapOf<Int, MutableList<String>>()
    repeat(numberOfInput) {
        val (name, price) = reader.readLine().split(" ")
        if (!prices.containsKey(price.toInt())) {
            prices[price.toInt()] = mutableListOf()
        }
        prices[price.toInt()]!!.add(name)
    }

    var name = ""
    var price = 0
    var size = Int.MAX_VALUE
    for (key in prices.keys) {
        if (size > prices[key]!!.size) {
            size = prices[key]!!.size
            name = prices[key]!!.first()
            price = key
        }
    }

    writer.write("$name $price")
    writer.flush()
}
