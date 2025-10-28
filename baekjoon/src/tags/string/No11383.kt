package tags.string

/**
 * https://www.acmicpc.net/problem/11383
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val image1 = Array(n) { readln() }
    val image2 = Array(n) { readln() }
    if (matches(n, m, image1, image2)) {
        println("Eyfa")
    } else {
        println("Not Eyfa")
    }
}

private fun matches(n: Int, m: Int, image1: Array<String>, image2: Array<String>): Boolean {
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (image1[i][j] != image2[i][j * 2] || image1[i][j] != image2[i][j * 2 + 1]) {
                return false
            }
        }
    }
    return true
}
