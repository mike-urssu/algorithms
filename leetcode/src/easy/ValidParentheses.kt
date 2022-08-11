package easy

import java.util.*

class ValidParentheses {
    private val stack = Stack<Char>()
    private val pairs = mapOf(Pair('(', ')'), Pair('{', '}'), Pair('[', ']'))

    fun isValid(s: String): Boolean {
        for (parenthesis in s) {
            if (pairs.keys.contains(parenthesis))
                stack.push(parenthesis)
            else {
                if (stack.isEmpty() || parenthesis != pairs[stack.pop()])
                    return false
            }
        }
        return stack.isEmpty()
    }
}