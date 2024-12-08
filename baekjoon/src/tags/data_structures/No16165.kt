package tags.data_structures

/**
 * https://www.acmicpc.net/problem/16165
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val teams = mutableMapOf<String, Set<String>>()
    val members = mutableMapOf<String, String>()

    repeat(n) {
        val team = readln()
        val size = readln().toInt()
        val names = sortedSetOf<String>()
        repeat(size) {
            val name = readln()
            names.add(name)
            members[name] = team
        }
        teams[team] = names
    }

    repeat(m) {
        val quiz = readln()
        val type = readln().toInt()
        if (type == 0) {
            teams[quiz]!!.forEach { println(it) }
        } else {
            println(members[quiz])
        }
    }
}
