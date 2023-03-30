package tags.string

/**
 * https://www.acmicpc.net/problem/1212
 */
fun main() {
    val octet = readln()
    val binary =
        if (octet == "0") {
            "0"
        } else {
            octet.map {
                when (it) {
                    '0' -> "000"
                    '1' -> "001"
                    '2' -> "010"
                    '3' -> "011"
                    '4' -> "100"
                    '5' -> "101"
                    '6' -> "110"
                    else -> "111"
                }
            }
                .joinToString("")
                .dropWhile { it == '0' }
        }
    println(binary)
}
