package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2160
 */
fun main() {
    val n = readln().toInt()
    val pictures = MutableList(n) {
        Array(5) { readln().toCharArray() }
    }

    val indices = IntArray(2)
    var min = Int.MAX_VALUE
    for (i in 0 until pictures.size - 1) {
        for (j in i + 1 until pictures.size) {
            val diff = getDiff(pictures[i], pictures[j])
            if (diff < min) {
                min = diff
                indices[0] = i + 1
                indices[1] = j + 1
            }
        }
    }

    println(indices.joinToString(" "))
}

private fun getDiff(picture1: Array<CharArray>, picture2: Array<CharArray>): Int {
    var count = 0
    for (i in 0..4) {
        for (j in 0..6) {
            if (picture1[i][j] != picture2[i][j]) {
                count++
            }
        }
    }
    return count
}
