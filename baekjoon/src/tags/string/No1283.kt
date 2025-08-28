package tags.string

/**
 * https://www.acmicpc.net/problem/1283
 */
private val shortcuts = mutableSetOf<Char>()

fun main() {
    val n = readln().toInt()
    val lines = Array(n) { readln() }
    lines.forEach { line -> println(parse(line)) }
}

private fun parse(line: String): String {
    val words = line.split(" ")
    for (i in words.indices) {
        val c = words[i].lowercase()[0]
        if (c !in shortcuts) {
            shortcuts.add(c)
            return words.mapIndexed { j, word ->
                if (i == j) {
                    "[${word[0]}]${word.substring(1)}"
                } else {
                    word
                }
            }.joinToString(" ")
        }
    }

    val lowercase = line.lowercase()
    val index = lowercase.indexOfFirst { it in 'a'..'z' && it !in shortcuts }
    if (index != -1) {
        shortcuts.add(lowercase[index])
        return "${line.substring(0, index)}[${line[index]}]${line.substring(index + 1)}"
    }

    return line
}
