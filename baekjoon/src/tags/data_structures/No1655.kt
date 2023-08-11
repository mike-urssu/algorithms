package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1655
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = reader.readLine().toInt()
    val frontQueue = PriorityQueue<Int>(Comparator.reverseOrder())
    val backQueue = PriorityQueue<Int>()
    (0 until n).forEach { i ->
        val a = reader.readLine().toInt()
        if (i % 2 == 0) {
            if (frontQueue.isEmpty()) {
                frontQueue.add(a)
            } else {
                if (backQueue.peek() > a) {
                    frontQueue.add(a)
                } else {
                    val back = backQueue.poll()
                    frontQueue.add(back)
                    backQueue.add(a)
                }
            }
        } else {
            if (frontQueue.peek() > a) {
                val front = frontQueue.poll()
                frontQueue.add(a)
                backQueue.add(front)
            } else {
                backQueue.add(a)
            }
        }
        writer.write("${frontQueue.peek()}\n")
    }
    writer.flush()
}
