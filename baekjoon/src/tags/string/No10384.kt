package tags.string

/**
 * https://www.acmicpc.net/problem/10384
 */
fun main() {
    val n = readln().toInt()
    (1..n).forEach { i ->
        val s = readln()
        println("Case $i: ${pangram(s.lowercase())}")
    }
}

private fun pangram(s: String): String {
    val counts = IntArray(26)
    s.forEach { c ->
        if (c in 'a'..'z') {
            counts[c - 'a']++
        }
    }
    return if (counts.all { it >= 3 }) {
        "Triple pangram!!!"
    } else if (counts.all { it >= 2 }) {
        "Double pangram!!"
    } else if (counts.all { it >= 1 }) {
        "Pangram!"
    } else {
        "Not a pangram"
    }
}
