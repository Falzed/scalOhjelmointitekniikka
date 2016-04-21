

object Main extends App {
  val mansikki = new Lehma("Mansikki")
  println(mansikki)   // Mansikki
  mansikki.aantele    // Ammuu
  println(mansikki.lypsa(mansikki.toString))   // 25.12
  mansikki.potkaise   // Lehmä potkaisee
  
  val tammukka = new Tamma("Tammukka")
  println(tammukka)   // Tammukka
  tammukka.aantele    // Ihahaa
  println(tammukka.lypsa(tammukka.toString))   // 9.84
  tammukka.potkaise   // Tamma potkaisee
  
  // Lopuksi tehdään juustoa:
  
  def juustoa(tuotantoelain: Lypsava):Double =
               42 * tuotantoelain.lypsa(tuotantoelain.toString)
  
  println(juustoa(mansikki))   // 1055.04
  println(juustoa(tammukka))   // 413.28

}