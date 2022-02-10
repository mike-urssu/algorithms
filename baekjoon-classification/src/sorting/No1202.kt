package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.Comparator

/**
 * https://www.acmicpc.net/problem/1202
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val input = reader.readLine().split(' ').map { it.toInt() }
    val countOfJewel = input[0]
    val countOfBags = input[1]

    val jewels = arrayListOf<IntArray>()
    for (i in 0 until countOfJewel) {
        val jewel = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
        jewels.add(jewel)
    }
    jewels.sortWith(compareBy({ it[0] }, { -it[1] }))

    val bags = IntArray(countOfBags)
    for (i in bags.indices) {
        val bag = reader.readLine().toInt()
        bags[i] = bag
    }
    bags.sort()

    var cost = 0L
    val queue = PriorityQueue<Int>(Comparator.reverseOrder())
    var index = 0
    for (bag in bags) {
        while (index < jewels.size && jewels[index][0] <= bag)
            queue.add(jewels[index++][1])
        if (!queue.isEmpty())
            cost += queue.poll()
    }

    writer.write(cost.toString())
    writer.flush()
}
