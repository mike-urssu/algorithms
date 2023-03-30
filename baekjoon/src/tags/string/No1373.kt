package tags.string

/**
 * https://www.acmicpc.net/problem/1373
 */
fun main() {
    var binary = readln()
    if (binary.length % 3 != 0) {
        binary = "0".repeat(3 - binary.length % 3) + binary
    }
    println(binaryToOctet(binary))
}

private fun binaryToOctet(binary: String): String {
    val octet = StringBuilder()
    for (i in 0 until binary.length / 3) {
        when (binary.substring(i * 3, i * 3 + 3)) {
            "000" -> octet.append("0")
            "001" -> octet.append("1")
            "010" -> octet.append("2")
            "011" -> octet.append("3")
            "100" -> octet.append("4")
            "101" -> octet.append("5")
            "110" -> octet.append("6")
            "111" -> octet.append("7")
        }
    }
    return octet.toString()
}
