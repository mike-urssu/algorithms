package tags.data_structures

/**
 * https://www.acmicpc.net/problem/18115
 */
fun main() {
    readln()
    val skills = readln().split(" ").map { it.toInt() }
    val order = ArrayDeque<Int>()

    var card = 1
    skills.reversed().forEach { i ->
        when (i) {
            1 -> order.addFirst(card)
            2 -> {
                val p = order.removeFirst()
                order.addFirst(card)
                order.addFirst(p)
            }

            3 -> order.add(card)
        }
        card++
    }

    val cards = StringBuilder()
    while (order.isNotEmpty()) {
        cards.append("${order.removeFirst()} ")
    }
    println(cards)
}
