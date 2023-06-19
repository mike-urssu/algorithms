package tags.string

/**
 * https://www.acmicpc.net/problem/3613
 */
fun main() {
    val s = readln()
    if (isJava(s)) {
        println(formatToCPP(s))
    } else if (isCPP(s)) {
        println(formatToJava(s))
    } else {
        println("Error!")
    }
}

private fun isJava(s: String): Boolean {
    if (s[0] !in 'a'..'z') {
        return false
    }
    if (s.any { it == '_' }) {
        return false
    }
    return true
}

private fun formatToCPP(s: String): String {
    val cpp = StringBuilder()
    for (c in s) {
        if (c in 'a'..'z') {
            cpp.append(c)
        } else {
            cpp.append('_')
            cpp.append(c.lowercaseChar())
        }
    }
    return cpp.toString()
}

private fun isCPP(s: String): Boolean {
    return if (s.first() == '_' || s.last() == '_') {
        false
    } else if (s.contains("__")) {
        false
    } else {
        s.all { it !in 'A'..'Z' }
    }
}

private fun formatToJava(s: String): String {
    val java = StringBuilder()
    var previousCharacter = '-'
    for (c in s) {
        if (previousCharacter == '_') {
            java.append(c.uppercaseChar())
        } else if (c in 'a'..'z') {
            java.append(c)
        }
        previousCharacter = c
    }
    return java.toString()
}
