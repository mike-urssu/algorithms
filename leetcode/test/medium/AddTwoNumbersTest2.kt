package medium

import utils.ListNode

fun main() {
    testAddTowNumbers(intArrayOf(7, 0, 8), intArrayOf(2, 4, 3), intArrayOf(5, 6, 4))
    testAddTowNumbers(intArrayOf(0), intArrayOf(0), intArrayOf(0))

    testAddTowNumbers(intArrayOf(7, 0, 4, 0, 1), intArrayOf(2, 4, 9), intArrayOf(5, 6, 4, 9))
    testAddTowNumbers(
        intArrayOf(6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
        intArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
        intArrayOf(5, 6, 4)
    )
}

private fun testAddTowNumbers(expectedNumbers: IntArray, numbers1: IntArray, numbers2: IntArray) {
    val expectedListNode = ListNode.getNodeListFromIntArray(expectedNumbers)

    val listNode1 = ListNode.getNodeListFromIntArray(numbers1)
    val listNode2 = ListNode.getNodeListFromIntArray(numbers2)
    val outputListNode = AddTwoNumbers2().addTwoNumbers(listNode1, listNode2)

    ListNode.testIsTwoListNodesEqual(expectedListNode, outputListNode)
}