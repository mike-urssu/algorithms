package tags.string

/**
 * https://www.acmicpc.net/problem/11816
 */
fun main() {
    val x = readln()
    val n = if (x.startsWith("0x")) {
        hexadecimalToDecimal(x.substring(2))
    } else if (x.startsWith("0")) {
        octalToDecimal(x.substring(1))
    } else {
        x
    }
    println(n)
}

private fun octalToDecimal(x: String): Int {
    var n = 0
    var o = 1
    for (i in x.lastIndex downTo 0) {
        n += x[i].digitToInt() * o
        o *= 8
    }
    return n
}

private fun hexadecimalToDecimal(x: String): Int {
    val hex = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')
    var n = 0
    var h = 1
    for (i in x.lastIndex downTo 0) {
        n += hex.indexOf(x[i]) * h
        h *= 16
    }
    return n
}
