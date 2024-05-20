package tags.implementation

/**
 * https://www.acmicpc.net/problem/2966
 */
fun main() {
    val n = readln().toInt()
    val input = readln().toCharArray()

    val scores = IntArray(3)
    scores[0] = getScore("ABC".toCharArray(), n, input)
    scores[1] = getScore("BABC".toCharArray(), n, input)
    scores[2] = getScore("CCAABB".toCharArray(), n, input)

    val names = arrayOf("Adrian", "Bruno", "Goran")
    val max = scores.max()

    println(max)
    scores.forEachIndexed { i, score ->
        if (score == max) {
            println(names[i])
        }
    }
}

private fun getScore(repeatedStr: CharArray, n: Int, input: CharArray) =
    (0 until n).count { i -> input[i] == repeatedStr[i % repeatedStr.size] }
