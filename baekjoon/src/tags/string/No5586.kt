package tags.string

/**
 * https://www.acmicpc.net/problem/5586
 */
fun main() {
    val s = readln()
    var joi = 0
    var ioi = 0
    (0..s.length - 3).forEach { i ->
        if (s[i] == 'J' && s[i + 1] == 'O' && s[i + 2] == 'I') {
            joi++
        } else if (s[i] == 'I' && s[i + 1] == 'O' && s[i + 2] == 'I') {
            ioi++
        }
    }
    println(joi)
    println(ioi)
}
