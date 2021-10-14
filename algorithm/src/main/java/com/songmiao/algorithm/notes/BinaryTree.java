package com.songmiao.algorithm.notes;

import com.songmiao.algorithm.entity.TreeNode;

/**
 * 二叉树
 */
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(33);
        treeNode.left = new TreeNode(16);
        treeNode.right = new TreeNode(50);
        treeNode.left.left = new TreeNode(13);
        treeNode.left.right = new TreeNode(18);
        treeNode.right.left = new TreeNode(34);
        treeNode.right.right = new TreeNode(58);
        treeNode.left.left.right = new TreeNode(15);
        treeNode.left.right.left = new TreeNode(17);
        treeNode.left.right.right = new TreeNode(25);
        treeNode.left.right.right.left = new TreeNode(19);
        treeNode.left.right.right.right = new TreeNode(27);
        printPermutations(new int[]{1,2,3},3,3);
    }
    /**
     * 前序遍历
     */
    public static void preorderTraversal(TreeNode treeNode){
        if(treeNode!=null){
            System.out.println(treeNode.val);
            preorderTraversal(treeNode.left);
            preorderTraversal(treeNode.right);
        }
    }
    /**
     * 中序遍历
     */
    public static void inOrderTraversal(TreeNode treeNode){
        if(treeNode!=null){
            inOrderTraversal(treeNode.left);
            System.out.println(treeNode.val);
            inOrderTraversal(treeNode.right);
        }
    }
    /**
     * 后续遍历
     */
    public static void postOrderTraversal(TreeNode treeNode){
        if(treeNode!=null){
            postOrderTraversal(treeNode.left);
            postOrderTraversal(treeNode.right);
            System.out.println(treeNode.val);
        }
    }

    /**
     * 计算二叉树的高度
     */
    public static int high(TreeNode treeNode){
        return highImpl(treeNode,0);
    }
    /**
     * 计算二叉树的高度
     */
    public static int highImpl(TreeNode treeNode,int height){
        if(treeNode==null){
            return height;
        }
        height++;
        int heightLeft = highImpl(treeNode.left,height);
        int heightRight = highImpl(treeNode.right,height);
        return heightLeft>heightRight?heightLeft:heightRight;
    }
    /**
     * 二叉查找树的查找操作
     */
    public static TreeNode binarySearchTreeFind(TreeNode treeNode,int data){
        if(treeNode==null){
            return null;
        }
        if(treeNode.val==data){
            return treeNode;
        }else if(treeNode.val>data){
            return binarySearchTreeFind(treeNode.left,data);
        }else{
            return binarySearchTreeFind(treeNode.right,data);
        }
    }

    /**
     * 二叉查找树的插入操作
     */
    public static TreeNode binarySearchTreeInsert(TreeNode treeNode,int data){
        if(treeNode==null){
            return new TreeNode(data);
        }
        TreeNode p = treeNode;
        while(p!=null){
            if(data>p.val){
                if(p.right==null){
                    p.right = new TreeNode(data);
                    return treeNode;
                }
                p = p.right;
            }else{
                if(p.left==null){
                    p.left = new TreeNode(data);
                    return treeNode;
                }
                p = p.left;
            }
        }
        return null;
    }
    /**
     * 二叉查找树的删除操作
     */
    public static void binarySearchTreeDelete(TreeNode treeNode,int data){
        TreeNode parent = null;//要删除数据的父节点
        TreeNode cur = treeNode;//当前删除节点
        //查找要删除的节点，定位他的父节点
        while(cur!=null && cur.val!=data){
            parent = cur;
            if(data > cur.val){
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        //两个节点都不为空的情况下，要找到他右节点子节点最小的数据（还要删除）替换他的位置
        if(cur.left!=null && cur.right!=null){
            TreeNode rightMin = cur.right;//右节点最小的位置
            TreeNode rightMinParent = cur;//他的父节点
            while(rightMin.left!=null){
                rightMinParent = rightMin;
                rightMin = rightMin.left;
            }
            cur.val = rightMin.val;
            cur = rightMin;
            parent = rightMinParent;
        }
        // 删除节点是叶子节点或者仅有一个节点
        TreeNode childs = null;
        if(cur.left!=null){
            childs = cur.left;
        }else if(cur.right!=null){
            childs = cur.right;
        }else{
            childs = null;
        }
        //删除
        if(parent==null){
            treeNode = childs;//删除的是根节点
        }else if(parent.left == cur){
            parent.left = childs;
        }else{
            parent.right = childs;
        }
    }

    public static void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
            printPermutations(data, n, k - 1);
            tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
        }
    }
}
