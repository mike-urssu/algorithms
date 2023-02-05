package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/1202
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val input = reader.readLine().split(' ').map { it.toInt() }
    val jewelCount = input[0]
    val bagCount = input[1]

    val jewels = arrayListOf<IntArray>()
    for (i in 0 until jewelCount) {
        val jewel = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
        jewels.add(jewel)
    }
    jewels.sortWith(compareBy({ it[0] }, { -it[1] }))

    val bags = IntArray(bagCount)
    for (i in 0 until bagCount)
        bags[i] = reader.readLine().toInt()
    bags.sort()

    writer.write(getMaximumCost(jewels, bags).toString())
    writer.flush()
}

fun getMaximumCost(jewels: List<IntArray>, bags: IntArray): Long {
    var cost = 0L
    val queue = PriorityQueue(Comparator.reverseOrder<Int>())
    var jewelIndex = 0
    for (bag in bags) {
        while (jewelIndex < jewels.size && jewels[jewelIndex][0] <= bag) {
            queue.add(jewels[jewelIndex][1])
            jewelIndex++
        }
        if (!queue.isEmpty())
            cost += queue.poll()
    }
    return cost
}
