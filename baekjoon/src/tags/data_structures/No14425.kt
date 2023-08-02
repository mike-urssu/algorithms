package tags.data_structures

/**
 * https://www.acmicpc.net/problem/14425
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val set = mutableSetOf<String>()
        .apply {
            repeat(n) {
                val s = readln()
                this.add(s)
            }
        }
    val count = (1..m).count {
        val s = readln()
        set.contains(s)
    }
    println(count)
}
