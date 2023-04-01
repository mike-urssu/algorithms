package tags.string

/**
 * https://www.acmicpc.net/problem/1652
 */
fun main() {
    val n = readln().toInt()
    val map = Array(n) { readln().toCharArray() }
    println("${getH(map, n)} ${getV(map, n)}")
}

private fun getH(map: Array<CharArray>, n: Int): Int {
    var h = 0
    for (i in 0 until n) {
        var count = 0
        for (j in 0 until n) {
            if (map[i][j] == '.') {
                count++
            } else {
                if (count >= 2) {
                    h++
                }
                count = 0
            }
        }
        if (count >= 2) {
            h++
        }
    }
    return h
}

private fun getV(map: Array<CharArray>, n: Int): Int {
    var v = 0
    for (j in 0 until n) {
        var count = 0
        for (i in 0 until n) {
            if (map[i][j] == '.') {
                count++
            } else {
                if (count >= 2) {
                    v++
                }
                count = 0
            }
        }
        if (count >= 2) {
            v++
        }
    }
    return v
}
