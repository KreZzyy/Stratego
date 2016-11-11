
object worksheet {
  1+2
  val p = Piece
  val arr= Array.ofDim[Square](10,10)
  val s =  Square('A',0, Piece(3))
  println(s.row + s.col)

  case class Square(row : Char, col : Int, var piece: Piece) {


  }

  case class Piece(rank: Int) {

  }

  case class Board(squares: Array.ofDim[Square]) {

    override def toString() {
      var sb = new StringBuilder()
      val vert = "|---"
      sb.append(vert * 10).append("\n")
    }

  }
}


//TODO: write scalatests tests
//TODO: change project structure to Maven
//TODO: join git project
//TODO: Board.toString()
//TODO: build an MVC arch