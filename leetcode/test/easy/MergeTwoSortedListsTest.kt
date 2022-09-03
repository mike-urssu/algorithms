package easy

import utils.ListNode

fun main() {
    testMergeTwoSortedLists(intArrayOf(1, 1, 2, 3, 4, 4), intArrayOf(1, 2, 4), intArrayOf(1, 3, 4))
    testMergeTwoSortedLists(null, null, null)
    testMergeTwoSortedLists(intArrayOf(0), intArrayOf(0), null)
}

private fun testMergeTwoSortedLists(expectedNumbers: IntArray?, numbers1: IntArray?, numbers2: IntArray?) {
    val expectedListNode = ListNode.getNodeListFromIntArray(expectedNumbers)

    val listNode1 = ListNode.getNodeListFromIntArray(numbers1)
    val listNode2 = ListNode.getNodeListFromIntArray(numbers2)
    val outputListNode = MergeTwoSortedLists().mergeTwoLists(listNode1, listNode2)

    ListNode.testIsTwoListNodesEqual(expectedListNode, outputListNode)
}