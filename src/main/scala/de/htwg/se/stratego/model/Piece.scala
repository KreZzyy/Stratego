package stratego

/** Creates Data Objects called Pieces based on rank.
  * 0 is Spy; 1 is Scout; 2 is Miner; 3 is Sergeant;
  * 4 is Leutenant; 5 is Bombs; 6 is Captain;
  * 7 is Major; 8 is Colonel; 9 is General;
  * 10 is Marshal; 11 is Flag; -1 is none
  * Created by ba431wed on 28.10.2016.
  */
case class Piece(rank: Int) {
  /**
    * Returns the rank.
    *
    * @return int, the rank
    */
  def getRank(): Int = {
    this.rank
  }
}