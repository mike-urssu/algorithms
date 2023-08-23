package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2605
 */
import java.util.LinkedList

fun main() {
    readln().toInt()
    val orders = readln().split(" ").map { it.toInt() }
    val list = LinkedList<Int>()
    orders.forEachIndexed { i, order ->
        list.add(order, i + 1)
    }
    while (list.isNotEmpty()) {
        print("${list.last} ")
        list.removeLast()
    }
}
