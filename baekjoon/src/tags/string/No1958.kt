package tags.string

/**
 * https://www.acmicpc.net/problem/1958
 */
fun main() {
    val s1 = "!" + readln()
    val s2 = "@" + readln()
    val s3 = "#" + readln()
    println(lcs(s1, s2, s3))
}

private fun lcs(s1: String, s2: String, s3: String): Int {
    val array = Array(s1.length) { Array(s2.length) { IntArray(s3.length) } }
    for (i in 1 until s1.length) {
        for (j in 1 until s2.length) {
            for (k in 1 until s3.length) {
                if (s1[i] == s2[j] && s2[j] == s3[k]) {
                    array[i][j][k] = array[i - 1][j - 1][k - 1] + 1
                } else {
                    array[i][j][k] = maxOf(array[i - 1][j][k], array[i][j - 1][k], array[i][j][k - 1])
                }
            }
        }
    }
    return array.last().last().last()
}
