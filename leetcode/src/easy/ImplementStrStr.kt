package easy

class ImplementStrStr {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.length > haystack.length)
            return -1

        for (i in 0..haystack.length - needle.length) {
            var isHaystackContainingNeedle = true
            for (j in needle.indices) {
                if (haystack[i + j] != needle[j]) {
                    isHaystackContainingNeedle = false
                    break
                }
            }

            if (isHaystackContainingNeedle)
                return i
        }

        return -1
    }
}
