package ch14

object ex6 extends App {

  sealed abstract class BinaryTree

  case class Leaf(value: Int) extends BinaryTree

  case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

  def sumLeaf(n: BinaryTree): Int = {
    n match {
      case Leaf(x) => x
      case Node(x, y) => sumLeaf(x) + sumLeaf(y)
      case _ => 0
    }
  }

  val tree = Node(Node(Leaf(3), Leaf(8)), Leaf(2))
  println(tree, sumLeaf(tree))
}

