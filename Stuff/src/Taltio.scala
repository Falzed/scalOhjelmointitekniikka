import scala.collection.mutable.ArrayBuffer
import MinSek._

class Taltio {
  val tallenteet = new ArrayBuffer[Tallenne]()
  
  def lisaaTallenne(tallenne: Tallenne) = {
    tallenteet+=tallenne
  }
  def poistaTallenne(tallenne: Tallenne) = {
    var index = ""
    var i = 0
    tallenteet.foreach { x =>
        if( x.equals(tallenne)) {
          index = i.toString
      }
    }
    if(!index.equals("")) {
      tallenteet.remove(index.toInt)
    }
  }
  override def toString: String = {
    var mjono = ""
    var minsek = new MinSek()
    tallenteet.foreach { x => 
      mjono+=minsek.toString()
      minsek+=x.getKesto
      mjono+=" "+x.getNimi+"\n"
    }
    mjono+="\n"+"Kokonaiskesto "+minsek.toString
    mjono
  }
}