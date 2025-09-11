package tags.string

/**
 * https://www.acmicpc.net/problem/1672
 */
fun main() {
    val n = readln().toInt()
    val chars = readln().toCharArray()

    var c = chars.last()
    (n - 1 downTo 1).forEach { i -> c = decode(c, chars[i - 1]) }
    println(c)
}

private fun decode(c1: Char, c2: Char): Char {
    return when (c1) {
        'A' -> {
            when (c2) {
                'A' -> 'A'
                'G' -> 'C'
                'C' -> 'A'
                else -> 'G'
            }
        }

        'G' -> {
            when (c2) {
                'A' -> 'C'
                'G' -> 'G'
                'C' -> 'T'
                else -> 'A'
            }
        }

        'C' -> {
            when (c2) {
                'A' -> 'A'
                'G' -> 'T'
                'C' -> 'C'
                else -> 'G'
            }
        }

        else -> {
            when (c2) {
                'A' -> 'G'
                'G' -> 'A'
                'C' -> 'G'
                else -> 'T'
            }
        }
    }
}
