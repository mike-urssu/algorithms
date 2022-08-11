package easy

fun main() {
    val validParentheses = ValidParentheses()
    assert(validParentheses.isValid("()"))
    assert(validParentheses.isValid("()[]{}"))
    assert(!validParentheses.isValid("(]"))
    assert(validParentheses.isValid("([]{})"))
    assert(!validParentheses.isValid("["))
    assert(!validParentheses.isValid(")"))
    assert(!validParentheses.isValid(")("))
    assert(!validParentheses.isValid("([]{)}"))
}