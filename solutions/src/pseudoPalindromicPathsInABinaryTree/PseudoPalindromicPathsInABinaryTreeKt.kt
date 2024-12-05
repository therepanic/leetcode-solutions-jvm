package pseudoPalindromicPathsInABinaryTree

import structures.treeNode.TreeNode

class PseudoPalindromicPathsInABinaryTreeKt {
    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        val answer = intArrayOf(0)
        traverse(root, IntArray(9), answer)
        return answer[0]
    }

    fun traverse(root: TreeNode?, count: IntArray, answer: IntArray) {
        if (root == null) return

        val index = root.`val` - 1
        count[index]++

        if (root.left != null) {
            traverse(root.left, count, answer)
        }

        if (root.right != null) {
            traverse(root.right, count, answer)
        }

        if (root.left == null && root.right == null) {
            var isOk = true
            var oddCount = 0

            for (i in count) {
                if (i % 2 != 0) {
                    oddCount++
                }

                if (oddCount > 1) {
                    isOk = false
                    break
                }
            }

            if (isOk) {
                answer[0]++
            }
        }

        count[index]--
    }
}