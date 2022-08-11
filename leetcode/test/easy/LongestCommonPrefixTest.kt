package easy

fun main() {
    val longestCommonPrefix = LongestCommonPrefix()
    assert(longestCommonPrefix.longestCommonPrefix(arrayOf("flower", "flow", "flight")) == "fl")
    assert(longestCommonPrefix.longestCommonPrefix(arrayOf("dog", "racecar", "car")) == "")
    assert(longestCommonPrefix.longestCommonPrefix(arrayOf("", "abc")) == "")
    assert(longestCommonPrefix.longestCommonPrefix(arrayOf("aaaaa", "aaaa", "aaa")) == "aaa")
}