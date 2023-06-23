package tags.string

/**
 * https://www.acmicpc.net/problem/2998
 */
fun main() {
    val values = mapOf(
        "000" to "0",
        "001" to "1",
        "010" to "2",
        "011" to "3",
        "100" to "4",
        "101" to "5",
        "110" to "6",
        "111" to "7"
    )

    val binary = readln()
    val paddingBinary = binary.padStart((binary.length + 2) / 3 * 3, '0')
    println(paddingBinary.chunked(3) { values[it] }.joinToString(""))
}
