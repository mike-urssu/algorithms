package tags.greedy

/**
 * https://www.acmicpc.net/problem/1213
 */
fun main() {
    val s = readln()
    val alphabets = s.groupingBy { it }.eachCount().toSortedMap()

    if (alphabets.values.count { it % 2 == 1 } > 1) {
        println("I'm Sorry Hansoo")
    } else {
        val prefix = StringBuilder().apply {
            alphabets.forEach { (c, i) -> repeat(i / 2) { this.append(c) } }
        }

        val singleAlphabet = alphabets.entries.firstOrNull { it.value % 2 == 1 }?.key
        if (singleAlphabet == null) {
            println("$prefix${prefix.reversed()}")
        } else {
            println("$prefix$singleAlphabet${prefix.reversed()}")
        }
    }
}
