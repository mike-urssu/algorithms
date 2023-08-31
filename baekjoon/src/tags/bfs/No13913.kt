package tags.bfs

/**
 * https://www.acmicpc.net/problem/13913
 */
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val paths = IntArray(100001) { -1 }

    val queue: Queue<Int> = LinkedList()
    queue.add(n)
    paths[n] = n
    while (queue.isNotEmpty()) {
        if (queue.peek() == k) {
            break
        }
        val p = queue.poll()
        if (p * 2 <= 100000 && paths[p * 2] == -1) {
            queue.add(p * 2)
            paths[p * 2] = p
        }
        if (p - 1 >= 0 && paths[p - 1] == -1) {
            queue.add(p - 1)
            paths[p - 1] = p
        }
        if (p + 1 <= 100000 && paths[p + 1] == -1) {
            queue.add(p + 1)
            paths[p + 1] = p
        }
    }

    if (n == k) {
        println(0)
        println(n)
    } else {
        val orders = Stack<Int>()
        orders.add(k)
        var p = paths[k]
        while (p != n) {
            orders.add(p)
            p = paths[p]
        }
        orders.add(p)
        println(orders.size - 1)
        while (orders.isNotEmpty()) {
            print("${orders.pop()} ")
        }
    }
}
