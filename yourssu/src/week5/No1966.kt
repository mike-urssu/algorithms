package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

/**
 * https://www.acmicpc.net/problem/1966
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val targetIndex = reader.readLine().split(" ").map { it.toInt() }[1]
        writer.write("${getPrintedOrder(targetIndex)}\n")
    }
    writer.flush()
}

private fun getPrintedOrder(targetIndex: Int): Int {
    var count = 0
    var currentIndex = targetIndex

    val priorityQueue = PriorityQueue<Int>(Comparator.reverseOrder())
    val queue: Queue<Int> = LinkedList()
    reader.readLine().split(" ").map { it.toInt() }.forEach { number ->
        priorityQueue.add(number)
        queue.add(number)
    }

    while (true) {
        while (priorityQueue.peek() != queue.peek()) {
            queue.add(queue.poll())
            currentIndex = (queue.size + currentIndex - 1) % queue.size
        }

        if (currentIndex == 0) {
            count++
            break
        } else {
            priorityQueue.poll()
            queue.poll()
            count++
            currentIndex--
        }
    }

    return count
}