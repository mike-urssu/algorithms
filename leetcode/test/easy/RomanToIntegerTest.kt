package easy

fun main() {
    val romanToInteger = RomanToInteger()
    assert(romanToInteger.romanToInt("III") == 3)
    assert(romanToInteger.romanToInt("IV") == 4)
    assert(romanToInteger.romanToInt("XIV") == 14)
    assert(romanToInteger.romanToInt("LVIII") == 58)
    assert(romanToInteger.romanToInt("MCMXCIV") == 1994)
    assert(romanToInteger.romanToInt("DCXXI") == 621)
}