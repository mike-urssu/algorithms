package tags.string

/**
 * https://www.acmicpc.net/problem/14405
 */
fun main() {
    val s = readln()
    if (isPikachu(s)) {
        println("YES")
    } else {
        println("NO")
    }
}

private fun isPikachu(s: String): Boolean {
    var index = 0
    while (index < s.length) {
        index += if (index + 1 < s.length && s[index] == 'p' && s[index + 1] == 'i') {
            2
        } else if (index + 1 < s.length && s[index] == 'k' && s[index + 1] == 'a') {
            2
        } else if (index + 2 < s.length && s[index] == 'c' && s[index + 1] == 'h' && s[index + 2] == 'u') {
            3
        } else {
            return false
        }
    }
    return true
}
