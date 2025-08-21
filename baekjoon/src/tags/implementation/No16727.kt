package tags.implementation

/**
 * https://www.acmicpc.net/problem/16727
 */
fun main() {
    val (p1, s1) = readln().split(" ").map { it.toInt() }
    val (s2, p2) = readln().split(" ").map { it.toInt() }
    val winner = if (p1 + p2 > s1 + s2) {
        "Persepolis"
    } else if (p1 + p2 < s1 + s2) {
        "Esteghlal"
    } else {
        if (s1 > p2) {
            "Esteghlal"
        } else if (s1 < p2) {
            "Persepolis"
        } else {
            "Penalty"
        }
    }
    println(winner)
}
