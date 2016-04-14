

object tutkailu extends App {
  import sys.process._
  import scala.util.control.Breaks._;
  import scala.io.StdIn._
  import scala.util.matching.Regex
  import java.io.File
  def sisaltavat(f: File, r: Regex): Array[File] = {
    val lista = f.listFiles
    val filtteroidyt = lista.filter(f => r.findFirstIn(f.getName).isDefined)
    filtteroidyt ++ lista.filter(_.isDirectory).flatMap(sisaltavat(_,r))
  }
  def alkavat(f: File, mjono: String): Array[File] = {
    val lista = f.listFiles
    val filtteroidyt = lista.filter { f => 
      f.getName.substring(0, mjono.length()).equals(mjono) }
//      lista.filter(f => r.findFirstIn(f.getName).isDefined)
    filtteroidyt ++ lista.filter(_.isDirectory).flatMap(alkavat(_,mjono))
  }
  def loppuvat(f: File, mjono: String): Array[File] = {
    val lista = f.listFiles
    val filtteroidyt = lista.filter { f => 
      f.getName.substring(f.getName.length-mjono.length, f.getName.length).equals(mjono) }
//      lista.filter(f => r.findFirstIn(f.getName).isDefined)
    filtteroidyt ++ lista.filter(_.isDirectory).flatMap(alkavat(_,mjono))
  }  
  def comp(eka :File, toka :File) :Boolean = {
    var res =false
    if(eka.compareTo(toka)<0) {
      return false
    }
    return true
  }
  override def main(args: Array[String]) {
    var kasky = ""
    breakable{while(true) {
      println(">")
      kasky = readLine
      if(kasky.equals("ls")) {
        val dir = new File("src")
        val regex = new Regex("")
        val lista = sisaltavat(dir, regex)
        lista.sortWith(comp)
        lista.foreach { x => println(x) }
      } else if(kasky.startsWith("ls -e")) {
        val dir = new File("src")
        if(kasky.length()>5) {
          val lista = loppuvat(dir, kasky.substring(6))
          lista.sortWith(comp)
          lista.foreach { x => println(x)}
          } else {
          println("ls -e tarvitsee parametrin")
        }
      } else if(kasky.startsWith("ls -b")) {
        val dir = new File("src")
        if(kasky.length()>5) {
          val lista = alkavat(dir, kasky.substring(6))
          lista.sortWith(comp)
          lista.foreach { x => println(x)}
          } else {
          println("ls -b tarvitsee parametrin")
        }
      } else if(kasky.startsWith("ls -c")) {
        val dir = new File("src")
        if(kasky.length()>5) {
          val regex = new Regex(kasky.substring(6))
          val lista = sisaltavat(dir, regex)
          lista.sortWith(comp)
          lista.foreach { x => println(x)}
          } else {
          println("ls -c tarvitsee parametrin")
        }
      } else if(kasky.equals("lo")) {
        break
      } else {
        println(kasky+" ei ole komento")
      }
    }}
  }
}