// --- Eläinten yhteinen yliluokka:

abstract class Elain (nimi:String) {
  var paino = 0
  def aantele: Unit             // abstrakti metodi
  def ulosta {
    if(this.paino>0) {
      this.paino-=1
    }
  }
  def syo {
    this.paino+=1
  }
  def setPaino(uusiPaino: Int) {
    this.paino=uusiPaino
  }
  def getPaino(): Int = {
    this.paino
  }
  override def toString = nimi  // korvattaessa "override" pakollinen
}
// --- Pari imettäväisiin kuuluvaa eläinlajia:
class Hevonen(nimi:String) extends Elain(nimi)  {
  override def aantele {println("Ihahaa")}
}
class Nauta(nimi:String) extends Elain(nimi)  {
  override def aantele {println("Ammuu")}
}
class Kissa(nimi:String) extends Elain(nimi) with Peto {
  override def aantele {println("Ihahaa")}
}
class Koira(nimi:String) extends Elain(nimi) with Peto {
  override def aantele {println("Ihahaa")}
}
class Vuohi(nimi:String) extends Elain(nimi)  {
  override def aantele {println("Ihahaa")}
}
class Kuttu(nimi:String) extends Elain(nimi)  {
  override def aantele {println("Ihahaa")}
}

// -- Ja sitten tehdään hienompi "traitti" lypsäville eläimille:

trait Lypsava extends Elain{
  private val id = scala.util.Random.nextDouble()
  def lypsa(n:String) =  {
      this.paino-=1
      3.14 * n.length
    } // ei-abstrakti metodi
  def potkaise:Unit  // abstrakti metodi eli Javan interfacen kaltainen "vaatimus"
}

trait Peto extends Elain{
  override def syo {
    this.paino+=2
  }
}

// Ja pari Lypsävää, joihin tuo "traitti" "mixataan in":

class Lehma(nimi:String) extends Nauta(nimi) with Lypsava {
   // lypsa(n:String) peritään traitista, so. oletustoteutus
   def potkaise {println("Lehmä potkaisee")}

}

class Tamma(nimi:String) extends Hevonen(nimi) with Lypsava {
  override def lypsa(n:String) = 1.23 * n.length  // korvataan peritty omalla
  def potkaise {println("Tamma potkaisee")}
}

