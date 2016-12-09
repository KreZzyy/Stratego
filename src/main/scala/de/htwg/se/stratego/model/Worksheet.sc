
object worksheet {
  println("21381")
  1+2
  val p = Piece
  val s =  Square('A',0, Piece(3))
  val f = "skdqnjkw"
  println(f.getClass())
  println(s.row + s.col)

  case class Square(row : Int, col : Char, var piece: Piece) {

    def getPiece(): Piece = {
      return this.piece
    }
  }

  case class Piece(rank: Int) {

    def getRank(): Int = {
      return this.rank
    }
  }

  case class Board(squares: Array[Array[Square]]) {


    override def toString(): String = {
      val sb = new StringBuilder()
      val vert = "|-"
      sb.append(vert * 10).append("|\n|")
      var i = 0
      var j = 0
      while (j < 10) {
        sb.append(squares(i)(j).getPiece().getRank()).append('|')
        i += 1
        if (i == 10 && j < 9) {
          j += 1
          sb.append("\n").append(vert * 10).append("|\n|")

          i = 0
        }
        if ( i == 10 && j == 9){
          j += 1
          sb.append("\n").append(vert * 10).append("|\n")
          i = 0
        }
      }
      sb.toString()
    }

  }

  var arr = Array.ofDim[Square](10, 10)

  //for (i <- 0 to 10 ; j <- 0 until 10) {

  //}
  for (i <- 0 until  10; j <- 0 to 9) { // until = exklusiv ; to = inklusiv
      arr(i)(j) = Square(i + 1, (j + 65).toChar, Piece(0))
  }
  //arr = Array((Square('A', 1, Piece(0)), Square('B', 1, Piece(0))), (Square('A', 2, Piece(0)),
  //  Square('B', 2, Piece(0))))
  val b = Board(arr)
  System.out.println("\n" + b.toString())

}


//TODO: write scalatests tests
//TODO: Board.toString()
//TODO: integrate with jenkins
