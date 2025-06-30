package tags.string

/**
 * https://www.acmicpc.net/problem/11091
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val s = readln().lowercase()
        val isVisited = BooleanArray(26)
        s.forEach { c ->
            if (c in 'a'..'z') {
                isVisited[c - 'a'] = true
            }
        }

        val r = if (isVisited.all { it }) {
            "pangram"
        } else {
            "missing ${(0 until 26).filter { !isVisited[it] }.map { 'a' + it }.joinToString("")}"
        }
        println(r)
    }
}
