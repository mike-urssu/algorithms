package tags.data_structures

/**
 * https://www.acmicpc.net/problem/9536
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val words = readln().split(" ").toMutableList()
        val cries = mutableSetOf<String>()
        while (true) {
            val s = readln()
            if (s == "what does the fox say?") {
                break
            }
            val cry = s.split(" ").last()
            cries.add(cry)
        }
        words.removeAll(cries)
        println(words.joinToString(" "))
    }
}
