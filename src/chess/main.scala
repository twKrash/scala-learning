package chess

import chess.main.Solution

case class Pos(x: Int, y: Int) {
  def +(other: Pos): Pos = Pos(x + other.x, y + other.y)

  def -(other: Pos): Pos = Pos(x - other.x, y - other.y)

  def abs() = Pos(Math.abs(x), Math.abs(y))
}

class Solver(private val figures: List[Figures], private val m: Int, private val n: Int) {

  private val _solutions: Solution = Map()

  def solve(): List[Solution] = {
    def solveAcc(state: Solution, figures: List[Figures], availablePositions: Set[Pos]): List[Solution] = {

      figures match {
        case Nil => List(state)
        case fig :: otherFig => val next = for {
          pos <- availablePositions.toList

          if state.forall { case (oPos, oFig) => !fig.canMove(pos, oPos)}
          nextState: Solution = state + (pos -> fig)
          newAvailablePositions = (availablePositions - pos).filter {
            oPos => !fig.canMove(oPos, pos)
          }
          nextSolution <- solveAcc(nextState, otherFig, newAvailablePositions)
        } yield nextSolution
          next.distinct
      }
    }
    val availablePositions = (for {
      y <- 0 until n
      x <- 0 until m
    } yield Pos(x, y)).toSet

    solveAcc(Map(), figures, availablePositions)
  }

  def solutions = _solutions

  def dimensions = (m, n)

}


object Solver {
  var n: Int = 8
  var m: Int = 8

  def apply(figures: List[Figures], _m: Int, _n: Int) = {
    n = _n
    m = _m
    new Solver(figures, m, n).solve()
  }

  def printOutput(solutionsList: List[Solution])(implicit limit: Int): Unit = {
    val list = if (limit > 0) {
      solutionsList.take(limit)
    } else {
      solutionsList
    }

    println("Solutions:" + solutionsList.size)
    for (solution <- list) {
      val cover = ("---" * m) + "-"
      val limitX = m - 1
      val limitY = n - 1
      println("┌" + cover + "┐")

      for {
        y <- 0 to limitY
        x <- 0 to limitX
      } {
        if (x == 0) print("| ")
        print(solution.getOrElse(Pos(x, y), " ") + " ")
        print(if (x != limitX) "|" else " |\n")
        if (x == limitX && y != limitY) print("|" + cover + "|\n")
      }
      println("└" + cover + "┘")
    }
  }
}


object main extends App {
  implicit val limit: Int = 0
  type Solution = Map[Pos, Figures]
  println("Start")
  val figures: List[Figures] = List(Queen, Queen, King, King, Bishop, Bishop, Knight)
  Solver.printOutput(Solver(figures, 7, 7))(10)
}
