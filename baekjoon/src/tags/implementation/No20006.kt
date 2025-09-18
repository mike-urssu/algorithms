package tags.implementation

/**
 * https://www.acmicpc.net/problem/20006
 */
fun main() {
    val (p, m) = readln().split(" ").map { it.toInt() }
    val players = Array(p) {
        val (l, n) = readln().split(" ")
        l.toInt() to n
    }

    val names = mutableListOf<MutableList<Pair<Int, String>>>().apply { this.add(mutableListOf()) }
    players.forEach { (l, n) ->
        var isInserted = false
        for (i in names.indices) {
            if (names[i].isEmpty() || (names[i].size < m && l in names[i].first().first - 10..names[i].first().first + 10)) {
                isInserted = true
                names[i].add(l to n)
                break
            }
        }
        if (!isInserted) {
            names.add(mutableListOf(l to n))
        }
    }

    names.indices.forEach { i ->
        if (names[i].size == m) {
            println("Started!")
        } else {
            println("Waiting!")
        }
        names[i].sortedBy { it.second }.forEach { (n, l) ->
            println("$n $l")
        }
    }
}
