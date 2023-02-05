package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1700
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val holeCount = reader.readLine().split(' ').map { it.toInt() }[0]
    val products = reader.readLine().split(' ').map { it.toInt() }

    var pluggedOut = 0
    val plugs = arrayListOf<Int>()
    for (i in products.indices) {
        val product = products[i]
        if (!plugs.contains(product)) {
            if (plugs.size < holeCount)
                plugs.add(product)
            else {
                val index = getIndexToPlugOut(plugs, products, i)
                plugs[index] = product
                pluggedOut++
            }
        }
    }

    writer.write(pluggedOut.toString())
    writer.flush()
}

fun getIndexToPlugOut(plugs: List<Int>, products: List<Int>, startIndex: Int): Int {
    val subProducts = products.subList(startIndex, products.size)
    for (i in plugs.indices) {
        if (!subProducts.contains(plugs[i]))
            return i
    }

    var plugIndex = 0
    var lastIndex = startIndex
    for (i in plugs.indices) {
        for (j in startIndex until products.size) {
            if (plugs[i] == products[j]) {
                if (lastIndex < j) {
                    lastIndex = j
                    plugIndex = i
                }
                break
            }
        }
    }
    return plugIndex
}
