package com.learn.algorithm.tree;

import lombok.Data;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

/**
 * 二叉树
 *
 * @author guoxingyong
 * @data 2019/5/23 14:36
 */
public class BinaryTree<T> {

    private TreeNode<T> rootTreeNode;

    public BinaryTree(TreeNode<T> rootTreeNode) {
        this.rootTreeNode = rootTreeNode;
    }

    public void frontShow() {
        rootTreeNode.frontShow();
    }

    public void midShow() {
        rootTreeNode.midShow();
    }

    public void afterShow() {
        rootTreeNode.afterShow();
    }


    @Data
    public static class TreeNode<T> {
        private T data;
        private TreeNode<T> leftTreeNode;
        private TreeNode<T> rightTreeNode;

        public TreeNode(T data) {
            this.data = data;
        }

        private void frontShow() {
            System.out.println(data);
            TreeNode<T> leftTreeNode = this.leftTreeNode;
            if (leftTreeNode != null) {
                leftTreeNode.frontShow();
            }
            TreeNode<T> rightTreeNode = this.rightTreeNode;
            if (rightTreeNode != null) {
                rightTreeNode.frontShow();
            }
        }

        private void midShow() {
            TreeNode<T> leftTreeNode = this.leftTreeNode;
            if (leftTreeNode != null) {
                leftTreeNode.frontShow();
            }
            System.out.println(data);
            TreeNode<T> rightTreeNode = this.rightTreeNode;
            if (rightTreeNode != null) {
                rightTreeNode.frontShow();
            }
        }

        private void afterShow() {
            TreeNode<T> leftTreeNode = this.leftTreeNode;
            if (leftTreeNode != null) {
                leftTreeNode.frontShow();
            }
            TreeNode<T> rightTreeNode = this.rightTreeNode;
            if (rightTreeNode != null) {
                rightTreeNode.frontShow();
            }
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        /*TreeNode<Integer> rootNode = new TreeNode<>(20);
        TreeNode<Integer> rootRightNode = new TreeNode<>(13);
        rootNode.setRightTreeNode(rootRightNode);
        TreeNode<Integer> rootLeftNode = new TreeNode<>(16);
        rootNode.setLeftTreeNode(rootLeftNode);
        TreeNode<Integer> rootRightRightNode = new TreeNode<>(10);
        rootRightNode.setRightTreeNode(rootRightRightNode);
        TreeNode<Integer> rootRightLeftNode = new TreeNode<>(6);
        rootRightNode.setLeftTreeNode(rootRightLeftNode);
        TreeNode<Integer> rootLeftRightNode = new TreeNode<>(8);
        rootLeftNode.setRightTreeNode(rootLeftRightNode);
        BinaryTree<Integer> binaryTree = new BinaryTree<>(rootNode);
        rootNode.frontShow();
        rootNode.midShow();
        rootNode.afterShow();*/

        int i = 11;
        byte[] b1 = new byte[4];
        b1[0] = (byte)  i;
        b1[1] = (byte) (i >> 8);
        b1[2] = (byte) (i >> 16);
        b1[3] = (byte) (i >> 24);
        System.out.println(Arrays.toString(b1));

        int val =11;
        byte[] b = new byte[4];
        b[0] = (byte)(val & 0xff);
        b[1] = (byte)((val >> 8) & 0xff);
        b[2] = (byte)((val >> 16) & 0xff);
        b[3] = (byte)((val >> 24) & 0xff);
        System.out.println(Arrays.toString(b));

        Charset.availableCharsets().forEach((k,v)-> System.out.println(k+":"+v));
    }
}
