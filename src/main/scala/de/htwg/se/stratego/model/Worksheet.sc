
object worksheet {
  1+2
  val p = Piece
  val arr = Array.ofDim[Square](10,10)
  val s =  Square('A',0, Piece(3))
  val f = "skdqnjkw"
  println(f.getClass())
  println(s.row + s.col)

  case class Square(row : Char, col : Int, var piece: Piece) {


  }

  case class Piece(rank: Int) {

  }
  type Arr10= Array.ofDim[Square](10,10)
  case class Board(squares: Array[Array[Square]]) {


    def toString() {
      val sb = new StringBuilder()
      val vert = "|---"
      sb.append(vert * 10).append("|\n|")
      var i = 0
      var j = 0
      while (true) {
        sb.append(squares(i)(j).getPiece().getRank()).append('|')
        i += 1
        if (i == 10) {
          j += 1
          sb.append("\n").append(vert * 10).append("|\n|")
          i = 0
        }
        if (j == 10) {
          break
        }
      }
      sb.toString()
    }

  }
}


//TODO: write scalatests tests
//TODO: Board.toString()
//TODO: integrate with jenkins
