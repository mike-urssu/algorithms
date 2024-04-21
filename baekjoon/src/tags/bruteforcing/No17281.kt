package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/17281
 */
private lateinit var innings: Array<IntArray>

private val orders = IntArray(9)
private val isVisited = BooleanArray(10)

private var max = 0

fun main() {
    val n = readln().toInt()
    innings = getInnings(n)

    orders[3] = 1
    isVisited[1] = true
    (2..9).forEach { i ->
        orders[0] = i
        isVisited[i] = true
        combination(1)
        isVisited[i] = false
    }

    println(max)
}

private fun getInnings(n: Int): Array<IntArray> {
    val innings = Array(n) { IntArray(10) }
    repeat(n) {
        val inning = readln().split(" ").map { it.toInt() }.toIntArray()
        inning.copyInto(innings[it], 1)
    }
    return innings
}

private fun combination(index: Int) {
    if (index == 9) {
        val score = calculateScore()
        max = max.coerceAtLeast(score)
        return
    }

    (2..9).forEach { i ->
        if (!isVisited[i]) {
            orders[index] = i
            isVisited[i] = true
            if (index + 1 == 3) {
                combination(4)
            } else {
                combination(index + 1)
            }
            isVisited[i] = false
        }
    }
}

private fun calculateScore(): Int {
    var index = 0
    var score = 0

    innings.forEach { inning ->
        val bases = BooleanArray(4)
        var out = 0
        while (out < 3) {
            when (inning[orders[index]]) {
                1 -> {
                    if (bases[3]) {
                        score++
                    }
                    bases[3] = bases[2]
                    bases[2] = bases[1]
                    bases[1] = true
                }

                2 -> {
                    if (bases[2]) {
                        score++
                    }
                    if (bases[3]) {
                        score++
                    }
                    bases[3] = bases[1]
                    bases[2] = true
                    bases[1] = false
                }

                3 -> {
                    if (bases[1]) {
                        score++
                    }
                    if (bases[2]) {
                        score++
                    }
                    if (bases[3]) {
                        score++
                    }
                    bases[1] = false
                    bases[2] = false
                    bases[3] = true
                }

                4 -> {
                    if (bases[1]) {
                        score++
                    }
                    if (bases[2]) {
                        score++
                    }
                    if (bases[3]) {
                        score++
                    }
                    score++
                    bases[1] = false
                    bases[2] = false
                    bases[3] = false
                }

                else -> {
                    out++
                }
            }
            index = (index + 1) % 9
        }
    }
    return score
}
