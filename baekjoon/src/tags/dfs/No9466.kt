package tags.dfs

/**
 * https://www.acmicpc.net/problem/9466
 */
private lateinit var numbers: IntArray
private lateinit var isVisited: BooleanArray
private lateinit var isDone: BooleanArray
private var count = 0

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        numbers = IntArray(n + 1).apply {
            readln().split(" ").forEachIndexed { index, i -> this[index + 1] = i.toInt() }
        }
        isVisited = BooleanArray(n + 1)
        isDone = BooleanArray(n + 1)
        count = 0
        println(countExcludedStudents(n))
    }
}

private fun countExcludedStudents(n: Int): Int {
    for (i in 1..n) {
        if (!isVisited[i]) {
            dfs(i)
        }
    }
    return n - count
}

private fun dfs(n: Int) {
    isVisited[n] = true

    if (!isVisited[numbers[n]]) {
        dfs(numbers[n])
    } else {
        if (!isDone[numbers[n]]) {
            var next = numbers[n]
            while (n != next) {
                next = numbers[next]
                count++
            }
            count++
        }
    }

    isDone[n] = true
}
