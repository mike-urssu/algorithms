package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/7568
 */
fun main() {
    val n = readln().toInt()
    val weightsAndHeights = Array(n) {
        val (w, h) = readln().split(" ").map { it.toInt() }
        Pair(w, h)
    }

    for (it in weightsAndHeights) {
        var rank = 1
        for (other in weightsAndHeights) {
            if (it.first < other.first && it.second < other.second) {
                rank++
            }
        }
        print("$rank ")
    }
}
