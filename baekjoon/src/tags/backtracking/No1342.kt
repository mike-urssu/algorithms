package tags.backtracking

/**
 * https://www.acmicpc.net/problem/1342
 */
private lateinit var s: String
private var n = 0
private lateinit var isVisited: BooleanArray
private var count = 0

fun main() {
    s = readln()
    n = s.length
    isVisited = BooleanArray(n)

    s.forEachIndexed { i, c ->
        isVisited[i] = true
        combination(1, "$c")
        isVisited[i] = false
    }

    val counts = IntArray(26)
    s.forEach { counts[it - 'a']++ }
    var div = 1
    counts.forEach {
        if (it > 1) {
            (2..it).forEach { k -> div *= k }
        }
    }
    println(count / div)
}

private fun combination(r: Int, str: String) {
    if (r == n) {
        count++
        return
    }

    s.forEachIndexed { i, c ->
        if (!isVisited[i] && str[r - 1] != c) {
            isVisited[i] = true
            combination(r + 1, str + c)
            isVisited[i] = false
        }
    }
}
