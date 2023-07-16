package tags.data_structures

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

/**
 * https://www.acmicpc.net/problem/1966
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val target = reader.readLine().split(" ").map { it.toInt() }[1]
        val priorities = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${getOrder(target, priorities)}")
        writer.newLine()
    }
    writer.flush()
}

private fun getOrder(target: Int, priorities: List<Int>): Int {
    val queue = LinkedList(priorities)
    var indexOfTarget = target

    val sortedPriorities = priorities.sortedDescending()
    var priorityIndex = 0

    while (true) {
        val currentPriority = queue.pollFirst()
        if (sortedPriorities[priorityIndex] == currentPriority) {
            if (indexOfTarget == 0) {
                priorityIndex++
                break
            }
            priorityIndex++
        } else
            queue.addLast(currentPriority)
        indexOfTarget = if (indexOfTarget == 0) queue.size - 1 else indexOfTarget - 1
    }
    return priorityIndex
}
