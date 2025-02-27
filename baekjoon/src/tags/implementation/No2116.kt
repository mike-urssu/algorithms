package tags.implementation

/**
 * https://www.acmicpc.net/problem/2116
 */
private lateinit var dices: Array<IntArray>

fun main() {
    val n = readln().toInt()
    dices = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val max = (0 until 6).maxOf { stack(dices[0][it]) }
    println(max)
}

private fun stack(k: Int): Int {
    var eye = k
    var sum = 0
    for (i in dices.indices) {
        val index = dices[i].indexOf(eye)
        val sides = when (index) {
            0, 5 -> intArrayOf(1, 2, 3, 4)
            1, 3 -> intArrayOf(0, 2, 4, 5)
            else -> intArrayOf(0, 1, 3, 5)
        }
        sum += sides.maxOf { dices[i][it] }

        eye = when (index) {
            0 -> dices[i][5]
            1 -> dices[i][3]
            2 -> dices[i][4]
            3 -> dices[i][1]
            4 -> dices[i][2]
            else -> dices[i][0]
        }
    }
    return sum
}
