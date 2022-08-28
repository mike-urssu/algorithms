package utils

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun getNodeListFromIntArray(numbers: IntArray): ListNode {
            val listNode = ListNode(numbers[0])
            var currentNode = listNode

            for (i in 1 until numbers.size) {
                val nextListNode = ListNode(numbers[i])
                currentNode.next = nextListNode
                currentNode = nextListNode
            }

            return listNode
        }

        fun testIsTwoListNodesEqual(expectedListNode: ListNode?, outputListNode: ListNode?) {
            var expected = expectedListNode
            var output = outputListNode

            while (expected != null && output != null) {
                assert(expected.`val` == output.`val`)
                expected = expected.next
                output = output.next
            }
        }
    }
}