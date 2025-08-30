package tags.string

/**
 * https://www.acmicpc.net/problem/11575
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        val s = readln()
        println(affineCipher(s, a, b))
    }
}

private fun affineCipher(s: String, a: Int, b: Int): String {
    val affineCipher = StringBuilder()
    s.forEach { c -> affineCipher.append('A' + (a * (c - 'A') + b) % 26) }
    return affineCipher.toString()
}
