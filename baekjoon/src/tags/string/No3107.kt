package tags.string

/**
 * https://www.acmicpc.net/problem/3107
 */
fun main() {
    val s = readln()
    val ipv6 = makeIPv6(s)
    println(ipv6.joinToString(":") { it.padStart(4, '0') })
}

private fun makeIPv6(s: String): List<String> {
    val parts = s.split(":")
    val ipv6 = mutableListOf<String>()

    if (parts.size == 8) {
        ipv6.addAll(parts)
    } else {
        val (l, r) = s.split("::")
        val leftParts = l.split(":")
        val rightParts = r.split(":")
        val count = 8 - leftParts.size - rightParts.size

        ipv6.addAll(leftParts)
        repeat(count) { ipv6.add("") }
        ipv6.addAll(rightParts)
    }
    return ipv6
}
