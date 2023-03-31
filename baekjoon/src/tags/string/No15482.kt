package tags.string

/**
 * https://www.acmicpc.net/problem/15482
 */
fun main() {
    val s1 = "@" + readln()
    val s2 = "#" + readln()
    val array = Array(s1.length) { IntArray(s2.length) }
    for (i in 1 until s1.length) {
        for (j in 1 until s2.length) {
            if (s1[i] == s2[j]) {
                array[i][j] = array[i - 1][j - 1] + 1
            } else {
                array[i][j] = array[i - 1][j].coerceAtLeast(array[i][j - 1])
            }
        }
    }
    println(array.last().last())
}
