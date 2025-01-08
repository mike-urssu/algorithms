package tags.data_structures

/**
 * https://www.acmicpc.net/problem/13417
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val letters = readln().split(" ").map { it[0] }.toCharArray()

        val deque = ArrayDeque<Char>()
        deque.add(letters[0])
        (1 until n).forEach { i ->
            val l = letters[i]
            if (deque.first() >= l) {
                deque.addFirst(l)
            } else {
                deque.add(l)
            }
        }

        while (deque.isNotEmpty()) {
            print(deque.removeFirst())
        }
        println()
    }
}
