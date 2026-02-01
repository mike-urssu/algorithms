package tags.string

/**
 * https://www.acmicpc.net/problem/18198
 */
fun main() {
    val chunks = readln().chunked(2)
    var scoreA = 0
    var scoreB = 0
    for (chunk in chunks) {
        val team = chunk[0]
        val score = chunk[1].digitToInt()
        if (team == 'A') {
            scoreA += score
        } else {
            scoreB += score
        }

        if (11 <= scoreA) {
            if (scoreB + 2 <= scoreA) {
                println('A')
                return
            }
        } else if (11 <= scoreB) {
            if (scoreA + 2 <= scoreB) {
                println('B')
                return
            }
        }
    }
}
