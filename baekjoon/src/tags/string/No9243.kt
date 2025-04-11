package tags.string

/**
 * https://www.acmicpc.net/problem/9243
 */
fun main() {
    val n = readln().toInt()
    val bits = readln().toCharArray()
    val bits2 = readln().toCharArray()

    if (n % 2 == 1) {
        bits.indices.forEach { i ->
            bits[i] = if (bits[i] == '0') {
                '1'
            } else {
                '0'
            }
        }
    }

    if (bits.contentEquals(bits2)) {
        println("Deletion succeeded")
    } else {
        println("Deletion failed")
    }
}
