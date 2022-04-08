package level2

import java.util.*

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */
class Parentheses {
    fun solution(p: String): String {
        if (p.isEmpty())
            return p

        var openParentheses = 0
        var closedParentheses = 0
        for (parenthesis in p) {
            if (parenthesis == '(') openParentheses++
            else closedParentheses++
            if (openParentheses == closedParentheses)
                break
        }
        val u = p.substring(0, openParentheses + closedParentheses)
        val v = p.substring(openParentheses + closedParentheses)

        return if (isParenthesesCompleted(u))
            u + solution(v)
        else
            parseParentheses(u, v)
    }

    private fun isParenthesesCompleted(u: String): Boolean {
        val stack = Stack<Char>()
        for (parenthesis in u) {
            if (parenthesis == '(')
                stack.push(parenthesis)
            else {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false
            }
        }
        return stack.isEmpty()
    }

    private fun parseParentheses(u: String, v: String): String {
        val builder = StringBuilder("(")
        builder.append(solution(v))
        builder.append(")")
        val substring = u.substring(1, u.length - 1)
        for (parenthesis in substring)
            builder.append(if (parenthesis == '(') ')' else '(')
        return builder.toString()
    }
}

fun main() {
    val parentheses = Parentheses()
    var p = "(()())()"
    println(parentheses.solution(p) == "(()())()")

    p = ")("
    println(parentheses.solution(p) == "()")

    p = "()))((()"
    println(parentheses.solution(p) == "()(())()")
}
