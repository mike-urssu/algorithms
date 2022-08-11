package easy

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        var commonPrefix = ""

        val shortestString = getShortestString(strs)
        for (index in shortestString.indices) {
            val character = shortestString[index]
            if (strs.all { str -> str[index] == character })
                commonPrefix += character
            else
                break
        }

        return commonPrefix
    }

    private fun getShortestString(strs: Array<String>): String {
        var shortestString = ""

        var size = Int.MAX_VALUE
        for (str in strs) {
            if (size > str.length) {
                size = str.length
                shortestString = str
            }
        }

        return shortestString
    }
}