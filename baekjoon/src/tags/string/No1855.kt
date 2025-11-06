package tags.string

/**
 * https://www.acmicpc.net/problem/1855
 */
fun main() {
    val k = readln().toInt()
    val encodedString = readln()

    val code = encodedString.chunked(k).mapIndexed { i, chunk ->
        if (i % 2 == 0) {
            chunk.toCharArray()
        } else {
            chunk.reversed().toCharArray()
        }
    }

    val decodedString = StringBuilder()
    for (j in 0 until k) {
        for (i in 0 until encodedString.length / k) {
            decodedString.append(code[i][j])
        }
    }
    println(decodedString)
}
