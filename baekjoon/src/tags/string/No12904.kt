package tags.string

/**
 * https://www.acmicpc.net/problem/12904
 */
fun main() {
    val s = readln()
    val t = readln()

    val str = StringBuilder(t)
    while (s.length < str.length) {
        if (str.last() == 'A') {
            str.deleteCharAt(str.lastIndex)
        } else {
            str.deleteCharAt(str.lastIndex)
            str.reverse()
        }
    }

    if (s == str.toString()) {
        println(1)
    } else {
        println(0)
    }
}
