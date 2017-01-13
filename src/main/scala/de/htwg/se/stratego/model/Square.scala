package stratego


/** Creates Data Objects to simulate Squares on a gameBoard.
  * Created by ba431wed on 28.10.2016.
  */
case class Square(row : Int, col : Char, piece: Piece) {

  /**
    * gets the chessBoard position of the Square.
    * @return tuple(Int, Char) the Position
    */
  def getPosit(): (Int, Char) = {
    (this.row, this.col)
  }

  def getPiece(): Piece = {
    piece
  }

}
