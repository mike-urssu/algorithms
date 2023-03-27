package tags.string

/**
 * https://www.acmicpc.net/problem/1157
 */
fun main() {
    val characters = mutableMapOf<Char, Int>()
    readln()
        .uppercase()
        .forEach { characters[it] = characters.getOrDefault(it, 0) + 1 }

    val max = characters.values.max()
    if (characters.count { it.value == max } == 1) {
        println(characters.entries.find { it.value == max }!!.key)
    } else {
        println("?")
    }
}
