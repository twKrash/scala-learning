package ch14

object ex8 extends App {

  sealed abstract class BinaryTree

  case class Leaf(value: Int) extends BinaryTree

  case class Node(op: Char, leafs: BinaryTree*) extends BinaryTree

  def eval(tree: BinaryTree): Int = {
    tree match {
      case Leaf(x) => x
      case Node(op, leafs@_*) => op match {
        case '+' => leafs.map(eval).sum
        case '-' => -leafs.map(eval).sum
        case '*' => leafs.map(eval).product
        case '/' => leafs.map(eval).reduceLeft(_ / _)
      }
    }
  }

  val tree = Node('/', Node('+',
    Node('*', Leaf(3), Leaf(8)),
    Leaf(2),
    Node('-', Leaf(5))
  ), Leaf(3))

  println(eval(tree))

}
