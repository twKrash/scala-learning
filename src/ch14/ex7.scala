package ch14

object ex7 extends App {

  sealed abstract class BinaryTree

  case class Leaf(value: Int) extends BinaryTree

  case class Node(leafs: BinaryTree*) extends BinaryTree


  def sumLeaf(n: BinaryTree): Int = {
    n match {
      case Leaf(x) => x
      case Node(leafs@_*) => leafs.map(sumLeaf).sum
    }
  }

  val tree = Node(Node(Leaf(3), Leaf(8)), Leaf(5), Node(Leaf(2)))

  import ch13.lect.time

  time {
    println(tree, sumLeaf(tree))
  }

  //  println(tree, sumLeaf(tree))

}
