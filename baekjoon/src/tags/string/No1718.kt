package tags.string

/**
 * https://www.acmicpc.net/problem/1718
 */
fun main() {
    val plainText = readln()
    val encryptionKey = readln()
    println(encrypt(plainText, encryptionKey))
}

private fun encrypt(plainText: String, encryptionKey: String): String {
    val alphabets = ('a'..'z').toList()
    val encryptedText = StringBuilder()
    plainText.forEachIndexed { i, c ->
        if (c == ' ') {
            encryptedText.append(' ')
        } else {
            val plainCharIndex = alphabets.indexOf(c)
            val keyCharIndex = alphabets.indexOf(encryptionKey[i % encryptionKey.length])
            val encryptedCharIndex = (plainCharIndex + 25 - keyCharIndex) % 26
            encryptedText.append(alphabets[encryptedCharIndex])
        }
    }
    return encryptedText.toString()
}
