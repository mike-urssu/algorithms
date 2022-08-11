package easy

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val solution = IntArray(2)
        val map = HashMap<Int, Int>()

        for (i in nums.indices) {
            if (map.containsKey(nums[i])) {
                solution[0] = map[nums[i]]!!
                solution[1] = i
                break
            }
            map[target - nums[i]] = i
        }

        return solution
    }
}
