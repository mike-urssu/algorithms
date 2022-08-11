package easy

class RomanToInteger {
    private val romanNumbers = HashMap<Char, Int>()

    init {
        romanNumbers['I'] = 1
        romanNumbers['V'] = 5
        romanNumbers['X'] = 10
        romanNumbers['L'] = 50
        romanNumbers['C'] = 100
        romanNumbers['D'] = 500
        romanNumbers['M'] = 1000
    }

    fun romanToInt(s: String): Int {
        var sum = 0
        val length = s.length
        for (i in 0 until length) {
            if (length > i + 1) {
                val currentValue = romanNumbers[s[i]]!!
                val nextValue = romanNumbers[s[i + 1]]!!
                if (currentValue < nextValue)
                    sum -= currentValue * 2
            }
            sum += romanNumbers[s[i]]!!
        }
        return sum
    }
}