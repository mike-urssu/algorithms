package tags.string

/**
 * https://www.acmicpc.net/problem/6996
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (s1, s2) = readln().split(" ")
        if (isAnagram(s1, s2)) {
            println("$s1 & $s2 are anagrams.")
        } else {
            println("$s1 & $s2 are NOT anagrams.")
        }
    }
}

private fun isAnagram(s1: String, s2: String): Boolean {
    val counts = IntArray(26)
    s1.forEach { counts[it - 'a']++ }
    s2.forEach { counts[it - 'a']-- }
    return counts.all { it == 0 }
}
