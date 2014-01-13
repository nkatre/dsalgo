You are given a binary tree. Print the level of the binary tree which has the maximum number of nodes. 
Break tie arbitrarily. 

/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/binary-tree-level-with-maximum-number.html
*/

package com.dsalgo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeLevelWithMaxNodes
{
 public static void main(String[] args)
 {
  Node a = new Node(1);
  Node b = new Node(2);
  Node c = new Node(3);
  Node d = new Node(4);
  Node e = new Node(5);
  Node f = new Node(8);
  Node g = new Node(6);
  Node h = new Node(7);
  a.left = b;
  a.right = c;
  b.left = d;
  b.right = e;
  c.right = f;
  f.left = g;
  f.right = h;
  printMaxLevel(a);
 }

 private static void printMaxLevel(Node a)
 {
  HashMap < Integer, List < Integer > > levelMap = new HashMap < Integer, List < Integer > >();
  printLevelOrder(a, 1, levelMap);
  int level = 1;
  int maxNodes = 0;
  List < Integer > values = null;
  while (true)
  {
   List < Integer > list = levelMap.get(level);
   if (list == null)
    break;
   if (list.size() > maxNodes)
   {
    maxNodes = list.size();
    values = list;
   }
   level++;
  }
  System.out.println(values);
 }

 private static void printLevelOrder(Node a, int level,
   HashMap < Integer, List < Integer > > levelMap)
 {
  if (a == null)
   return;
  List < Integer > list = levelMap.get(level);
  if (list == null)
  {
   list = new ArrayList < Integer > ();
   list.add(a.value);
   levelMap.put(level, list);
  } else
  {
   list.add(a.value);
  }
  printLevelOrder(a.left, level + 1, levelMap);
  printLevelOrder(a.right, level + 1, levelMap);
 }

 static class Node
 {
  Node left;
  Node right;
  int value;

  public Node(int value)
  {
   this.value = value;
  }
 }

}

