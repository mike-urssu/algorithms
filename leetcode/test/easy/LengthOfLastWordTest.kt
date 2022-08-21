package easy

fun main() {
    val lengthOfLastWord = LengthOfLastWord()
    assert(lengthOfLastWord.lengthOfLastWord("Hello World") == 5)
    assert(lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  ") == 4)
    assert(lengthOfLastWord.lengthOfLastWord("luffy is still joyboy") == 6)
}