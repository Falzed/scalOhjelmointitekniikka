import MinSek._

class Tallenne(nimiArg: String, kestoArg: MinSek) {
  val kesto = kestoArg
  val nimi = nimiArg
  
  def getKesto: MinSek = {
    kesto
  }
  def getNimi: String = {
    nimi
  }
  def equals(verrattava: Tallenne): Boolean = {
    (nimi.equals(verrattava.getNimi) && kesto.equals(verrattava.getKesto))
  }
  override def toString: String = {
    val mjono = kesto.toString() + " " +nimi+"\n"
    mjono
  }
}