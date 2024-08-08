package tags.backtracking

/**
 * https://www.acmicpc.net/problem/17825
 */
private val scores = intArrayOf(
    0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0,
    10, 13, 16, 19, 25, 30, 35, 40, 0,
    20, 22, 24, 25, 30, 35, 40, 0,
    30, 28, 27, 26, 25, 30, 35, 40, 0
)
private lateinit var isVisited: BooleanArray

private lateinit var dices: IntArray
private val orders = IntArray(10)

private var max = 0

fun main() {
    dices = readln().split(" ").map { it.toInt() }.toIntArray()
    dfs(0)
    println(max)
}

private fun dfs(index: Int) {
    if (index == 10) {
        calculate()
        return
    }

    (0 until 4).forEach { i ->
        orders[index] = i
        dfs(index + 1)
    }
}

private fun calculate() {
    val horses = IntArray(4)
    isVisited = BooleanArray(scores.size)

    var score = 0
    orders.forEachIndexed { i, index ->
        val current = horses[index]
        val next = getNext(current, dices[i])
        if (!canMove(current, next)) {
            return
        }
        moveHorse(horses, index, current, next)
        score += scores[next]
    }

    max = max.coerceAtLeast(score)
}

private fun getNext(current: Int, dice: Int): Int {
    var next = current + dice

    if (current < 21) {
        if (next > 21) {
            next = 21
        }
    } else if (current < 30) {
        if (next > 30) {
            next = 30
        }
    } else if (current < 38) {
        if (next > 38) {
            next = 38
        }
    } else {
        if (next > 47) {
            next = 47
        }
    }

    return when (next) {
        5 -> 22
        10 -> 31
        15 -> 39
        26, 34, 43 -> 43
        27, 35, 44 -> 44
        28, 36, 45 -> 45
        20, 29, 37, 46 -> 46
        21, 30, 38, 47 -> 47
        else -> next
    }
}

private fun canMove(current: Int, next: Int): Boolean {
    if (current == 47) {
        return false
    }
    if (next == 47) {
        return true
    }

    if (isVisited[next]) {
        return false
    }
    return true
}

private fun moveHorse(horses: IntArray, index: Int, current: Int, next: Int) {
    horses[index] = next
    isVisited[current] = false
    isVisited[next] = true
}
