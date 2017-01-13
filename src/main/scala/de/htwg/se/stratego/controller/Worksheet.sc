import java.util

import stratego.{Board, Piece, Square}


class PlacementMenu {
  var pieces = new util.HashMap[Integer, Integer]()
  val in = new java.util.Scanner(System.in)
  pieces.put(0, 1)
  pieces.put(1, 8)
  pieces.put(2, 5)
  pieces.put(3, 4)
  pieces.put(5, 6)
  pieces.put(6, 4)
  pieces.put(7, 3)
  pieces.put(8, 2)
  pieces.put(9, 1)
  pieces.put(10, 1)
  pieces.put(11, 1)

  while (in.hasNext()) {
    val line = in.nextLine()
    val split = line.split(" ")
    var p = String
    var at = String
    if (split.length == 2) {
      p = split(0)
      at = split(1)
    } else {
      print("Please enter a rank:Int Position: CharInt!")
    }
    if ((at.charAt(0) == 'C' || at.charAt(0) == 'D' || at.charAt(0) == 'G' || at.charAt(0) == 'H' )
      && Integer.valueOf(at.charAt(1)) > 4 && Integer.valueOf(at.charAt(1)) < 6) {

    }
  }
}

class MoveMenu(board: Board) {
  val in = new java.util.Scanner(System.in)

  def moveCommand(from: String, to: String) : Unit = {
    var f = board.getSquare(from.charAt(1), from.charAt(0))
    var t = board.getSquare(to.charAt(1), to.charAt(0))
    if (f.getPiece().getRank() != -1 && f.piece.rank != 11 && f.piece.rank != 5) {
      if (!f.getPiece().getColour().equals(t.getPiece().getColour())) {
        if (t.getPiece().getRank() == -1) {
          board.squares(to.charAt(1))(to.charAt(0) - 65) = new Square(t.row, t.col, f.getPiece())
          board.squares(from.charAt(1))(from.charAt(0) - 65) = new Square(f.row, f.col, new Piece(-1, "none"))
        } else { //colour ungleich, Piece exists: Attack
          if (t.piece.rank == 5) {//BOMB!!
            if (f.piece.rank != 2) {//Boom!!!
              board.squares(from.charAt(1))(from.charAt(0) - 65) = new Square(f.row, f.col, new Piece(-1, "none"))
              print("Someone has set us up the Bomb!")
            } else {
              board.squares(from.charAt(1))(from.charAt(0) - 65) = new Square(f.row, f.col, new Piece(-1, "none"))
              board.squares(to.charAt(1))(to.charAt(0) - 65) = new Square(t.row, t.col, f.getPiece())
              print("Bomb defused! Counter Terrorists win!")
            }
          } else if (t.piece.rank == 11) {//Victory
            print("Current player found the Flag! Victory!")
          } else if (f.piece.rank > t.piece.rank) {
            board.squares(to.charAt(1))(to.charAt(0) - 65) = new Square(t.row, t.col, f.getPiece())
            board.squares(from.charAt(1))(from.charAt(0) - 65) = new Square(f.row, f.col, new Piece(-1, "none"))
            print("Enemy piece is: " + t.piece.getRank() + " Success!")
          } else if (f.piece.rank == 0 && t.piece.rank == 10) {
            board.squares(to.charAt(1))(to.charAt(0) - 65) = new Square(t.row, t.col, f.getPiece())
            board.squares(from.charAt(1))(from.charAt(0) - 65) = new Square(f.row, f.col, new Piece(-1, "none"))
            print("Enemy piece is: " + t.piece.rank + " Success!")
          } else { //Mission failed... We'll get em next time!
            board.squares(from.charAt(1))(from.charAt(0) - 65) = new Square(f.row, f.col, new Piece(-1, "none"))
            print("Enemy Piece is: " + t.piece.rank + " Fission Mailed!")
          }
        }
      }
    }
    print(board.toString())
  }

  while (in.hasNext()) {
    val line = in.nextLine()
    val split = line.split(" ")
    var from = String
    var to = String
    if (split.length == 2) {
      from = split(0)
      to = split(1)
    }
    moveCommand(from, to)
  }
}

class Output(board: Board, player: String) {
  print(board.toString())
  print(player + "'s turn to move.")

}