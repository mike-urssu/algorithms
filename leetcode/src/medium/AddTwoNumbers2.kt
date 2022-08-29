package medium

import utils.ListNode

class AddTwoNumbers2 {
    private lateinit var currentListNode: ListNode
    private var listNode1: ListNode? = null
    private var listNode2: ListNode? = null
    private var carry = 0

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val listNode = ListNode(0)
        currentListNode = listNode
        listNode1 = l1
        listNode2 = l2

        while (listNode1 != null && listNode2 != null) {
            val sum = listNode1!!.`val` + listNode2!!.`val` + carry
            carry = sum / 10

            val nextListNode = ListNode(sum % 10)
            currentListNode.next = nextListNode
            currentListNode = nextListNode

            listNode1 = listNode1!!.next
            listNode2 = listNode2!!.next
        }

        while (listNode1 != null) {
            connectListNode(listNode1)
            listNode1 = listNode1!!.next
        }

        while (listNode2 != null) {
            connectListNode(listNode2)
            listNode2 = listNode2!!.next
        }

        if (carry == 1)
            currentListNode.next = ListNode(1)

        return listNode.next
    }

    private fun connectListNode(listNode: ListNode?) {
        val sum = listNode!!.`val` + carry
        carry = sum / 10

        val nextListNode = ListNode(sum % 10)
        currentListNode.next = nextListNode
        currentListNode = nextListNode
    }
}