package week3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

/**
 * https://www.acmicpc.net/problem/1655
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val leftHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    val rightHeap = PriorityQueue<Int>()

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) { i ->
        val number = reader.readLine().toInt()
        val selectedHeap = if (i % 2 == 0) leftHeap else rightHeap
        selectedHeap.add(number)

        if (leftHeap.isNotEmpty() && rightHeap.isNotEmpty()) {
            if (leftHeap.peek() > rightHeap.peek())
                swap(leftHeap, rightHeap)
        }

        writer.write("${leftHeap.peek()}\n")
    }
    writer.flush()
}

private fun swap(leftHeap: PriorityQueue<Int>, rightHeap: PriorityQueue<Int>) {
    val max = leftHeap.poll()
    val min = rightHeap.poll()
    leftHeap.add(min)
    rightHeap.add(max)
}