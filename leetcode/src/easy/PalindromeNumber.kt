package easy

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0)
            return false

        var sum: Long = 0
        var divider: Long = 1

        while (x.toLong() / divider != 0L) {
            sum = sum * 10 + x % (divider * 10) / divider
            divider *= 10
        }

        return sum == x.toLong()
    }
}
