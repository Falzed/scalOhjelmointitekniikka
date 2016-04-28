

object tulostus extends App {
  trait KoristellenTulostettava {
    def koristettava: String
    def koristemerkki: Char
    def reunusta = println(koristemerkki + koristettava + koristemerkki)
    def alleviivaa = println("\033"+"[4m "+koristettava+"[0m")
    def ylaviivaa = println("\033"+"[9m "+koristettava+"[0m")
    //... alleviivaa, ylleviivaa, ymparoi, ...
  }

  class Kuka(var nimi: String) extends KoristellenTulostettava {
    override def koristettava = nimi
    override val koristemerkki = '*'
  }

  val pm = new Kuka("Putin")
  pm.reunusta                    // *Putin*
  pm.nimi = "Obama"
  pm.reunusta                    // *Obama*
  pm.alleviivaa
  pm.ylaviivaa

  class Luku(var arvo: Int) extends KoristellenTulostettava {
    override def koristettava = " " + arvo * 2 + " "
    override def koristemerkki = math.abs(arvo)%256 toChar
  }

  val se = new Luku(42)
  se.reunusta           // * 84 *
  se.arvo = 93
  se.reunusta           // ] 186 ]
  se.arvo = -3301
  se.reunusta           // å -6602 å
}