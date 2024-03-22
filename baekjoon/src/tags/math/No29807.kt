package tags.math

/**
 * https://www.acmicpc.net/problem/29807
 */
fun main() {
    val scores = IntArray(5)
    readln()
    readln().split(" ").forEachIndexed { i, score -> scores[i] = score.toInt() }

    var schoolNumber = if (scores[0] > scores[2]) {
        (scores[0] - scores[2]) * 508
    } else {
        (scores[2] - scores[0]) * 108
    }
    schoolNumber += if (scores[1] > scores[3]) {
        (scores[1] - scores[3]) * 212
    } else {
        (scores[3] - scores[1]) * 305
    }
    schoolNumber += scores[4] * 707
    schoolNumber *= 4763

    println(schoolNumber)
}
