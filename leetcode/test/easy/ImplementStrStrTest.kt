package easy

fun main() {
    val implementStrStr = ImplementStrStr()
    assert(implementStrStr.strStr("hello", "ll") == 2)
    assert(implementStrStr.strStr("aaaaa", "bba") == -1)

    assert(implementStrStr.strStr("aaaaa", "a") == 0)
    assert(implementStrStr.strStr("aaaaa", "aaaaa") == 0)
    assert(implementStrStr.strStr("aaaabb", "aaaabbb") == -1)
}