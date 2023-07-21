package tags.sorting

/**
 * https://www.acmicpc.net/problem/9076
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val scores = readln().split(" ").map { it.toInt() }.sorted().drop(1).dropLast(1)
        if (scores.last() - scores.first() >= 4) {
            println("KIN")
        } else {
            println(scores.sum())
        }
    }
}
