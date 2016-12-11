package stratego

/** Creates Data Object simulating a GameBoard
  * Created by ba431wed on 28.10.2016.
  */
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
