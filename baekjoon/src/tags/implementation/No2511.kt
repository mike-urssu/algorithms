package tags.implementation

/**
 * https://www.acmicpc.net/problem/2511
 */
fun main() {
    val a = readln().split(" ").map { it.toInt() }.toIntArray()
    val b = readln().split(" ").map { it.toInt() }.toIntArray()

    var scoreA = 0
    var scoreB = 0
    (0 until 10).forEach { i ->
        if (a[i] > b[i]) {
            scoreA += 3
        } else if (a[i] == b[i]) {
            scoreA++
            scoreB++
        } else {
            scoreB += 3
        }
    }

    val index = (0 until 10).indexOfLast { i -> a[i] != b[i] }
    val winner = if (index == -1) {
        "D"
    } else {
        if (scoreA > scoreB) {
            "A"
        } else if (scoreA < scoreB) {
            "B"
        } else {
            if (a[index] > b[index]) {
                "A"
            } else {
                "B"
            }
        }
    }

    println("$scoreA $scoreB")
    println(winner)
}
