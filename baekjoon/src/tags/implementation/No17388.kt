package tags.implementation

/**
 * https://www.acmicpc.net/problem/17388
 */
fun main() {
    val scores = readln().split(" ").map { it.toInt() }
    if (scores.sum() >= 100) {
        println("OK")
    } else {
        val school = when (scores.indexOf(scores.min())) {
            0 -> "Soongsil"
            1 -> "Korea"
            else -> "Hanyang"
        }
        println(school)
    }
}
