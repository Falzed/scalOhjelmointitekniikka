import scala.io.StdIn

object Kieli {
    def jos(lause: Boolean)(body: => Unit) {
      if(lause) body
    }
    def kirjoita(kirjoitettava: Object) {
      println(kirjoitettava.toString)
    }
    def kirjoita(kirjoitettava: Boolean) {
      println(kirjoitettava.toString)
    }
    def kirjoita(kirjoitettava: Int) {
      println(kirjoitettava.toString)
    }
    def lue(): Int = {
      val luettu = scala.io.StdIn.readLine()
      return luettu.toInt
    }
    def toista(kertaa:Int)(algoritmi: =>Unit) {
      for (i <- 1 to kertaa) algoritmi
    }

    def toista(kertaa: String)(algoritmi: => Unit) {
      for(i <- 1 to kertaa.toInt) algoritmi
    }
    def toistaEhdolla(ehto: => Boolean)(algoritmi: =>Unit) {
      do {
        algoritmi
      } while (ehto)
    }
}