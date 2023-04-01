package tags.string

/**
 * https://www.acmicpc.net/problem/1213
 */
fun main() {
    val s = readln()
    val characters = sortedMapOf<Char, Int>()
    s.forEach { characters[it] = characters.getOrDefault(it, 0) + 1 }
    val palindrome = StringBuilder()

    if (characters.values.count { it % 2 == 1 } > 1) {
        palindrome.append("I'm Sorry Hansoo")
    } else {
        val prefix = characters.entries.joinToString("") { it.key.toString().repeat(it.value / 2) }

        palindrome.append(prefix)
        val c = characters.keys.find { key -> characters[key]!! % 2 == 1 }
        c?.let { palindrome.append(it) }
        palindrome.append(prefix.reversed())
    }
    println(palindrome)
}
