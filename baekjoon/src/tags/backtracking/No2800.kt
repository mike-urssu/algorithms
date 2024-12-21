package tags.backtracking

/**
 * https://www.acmicpc.net/problem/2800
 */
import java.util.Stack

private lateinit var formula: String
private val formulas = sortedSetOf<String>()
private lateinit var pairs: List<Pair<Int, Int>>
private lateinit var isVisited: BooleanArray

fun main() {
    formula = readln()
    pairs = getPairs()

    isVisited = BooleanArray(pairs.size)
    combination(0)

    formulas.remove(formula)
    formulas.forEach { println(it) }
}

private fun getPairs(): List<Pair<Int, Int>> {
    val pairs = mutableListOf<Pair<Int, Int>>()
    val stack = Stack<Int>()
    formula.forEachIndexed { i, c ->
        if (c == '(') {
            stack.push(i)
        } else if (c == ')') {
            pairs.add(stack.pop() to i)
        }
    }
    return pairs
}

private fun combination(index: Int) {
    if (index == pairs.size) {
        formulas.add(create())
        return
    }

    isVisited[index] = true
    combination(index + 1)
    isVisited[index] = false
    combination(index + 1)
}

private fun create(): String {
    val validIndices = BooleanArray(formula.length) { true }
    pairs.forEachIndexed { i, (a, b) ->
        if (isVisited[i]) {
            validIndices[a] = false
            validIndices[b] = false
        }
    }

    val s = StringBuilder()
    formula.forEachIndexed { i, c ->
        if (validIndices[i]) {
            s.append(c)
        }
    }
    return s.toString()
}
