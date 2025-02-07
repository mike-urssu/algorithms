package tags.string

/**
 * https://www.acmicpc.net/problem/20540
 */
fun main() {
    val mbti = readln()
    val ideal = mbti.map {
        when (it) {
            'E' -> 'I'
            'I' -> 'E'
            'N' -> 'S'
            'S' -> 'N'
            'F' -> 'T'
            'T' -> 'F'
            'J' -> 'P'
            else -> 'J'
        }
    }
    println(ideal.joinToString(""))
}
