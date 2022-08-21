package easy

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        return s.trim().split(" ").last().length
    }
}