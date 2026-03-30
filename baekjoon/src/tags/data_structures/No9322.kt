package tags.data_structures

/**
 * https://www.acmicpc.net/problem/9322
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val publicKey1 = readln().split(" ")
        val publicKey2 = readln().split(" ")
        val cryptogram = readln().split(" ")

        val keyIndexMap = publicKey1.withIndex().associate { it.value to it.index }
        val plainText = Array(n) { "" }
        (0 until n).forEach { i ->
            val index = keyIndexMap.getValue(publicKey2[i])
            plainText[index] = cryptogram[i]
        }
        println(plainText.joinToString(" "))
    }
}
