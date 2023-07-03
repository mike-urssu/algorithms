package tags.string

/**
 * https://www.acmicpc.net/problem/2954
 */
fun main() {
    val s = readln()
    println(decode(s))
}

private fun decode(s: String): String {
    val vowels = arrayOf('a', 'e', 'i', 'o', 'u')
    val text = StringBuilder()
    var index = 0
    while (index < s.length) {
        text.append(s[index])
        if (s[index] in vowels) {
            index += 3
        } else {
            index++
        }
    }
    return text.toString()
}
