package easy

fun main() {
    val palindromeNumber = PalindromeNumber()
    assert(palindromeNumber.isPalindrome(121))
    assert(!palindromeNumber.isPalindrome(123))
    assert(!palindromeNumber.isPalindrome(-121))
    assert(!palindromeNumber.isPalindrome(10))
    assert(palindromeNumber.isPalindrome(0))
    assert(palindromeNumber.isPalindrome(7))
    assert(palindromeNumber.isPalindrome(1410110141))
}
