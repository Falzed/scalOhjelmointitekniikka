

object huonoToteutus extends App {
  import scala.collection.mutable.ArrayBuffer;
  import scala.util.control.Breaks._;
  def generateYlaraja(ylaraja :Int) :ArrayBuffer[Int] = {
      val arrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Int]
      var jaollinen = false
      for(i<-2 to ylaraja) {
        jaollinen=false
        breakable{arrayBuffer.foreach { x => if(i%x==0) {
          jaollinen = true
          break
        }}}
        if(!jaollinen) { arrayBuffer+=i }
      }
      return arrayBuffer
  }
  def generate(n :Int) :ArrayBuffer[Int] = {
      val arrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Int]
      var jaollinen = false
      var i = 1
      var j = 3
      arrayBuffer+=2
      breakable {while(i<n) {
        jaollinen=false
        breakable{arrayBuffer.foreach { x => if(j%x==0) {
          jaollinen = true
          break
        }}}
        if(!jaollinen) { 
          arrayBuffer+=j
          i+=1
        }
        j+=1
      }}
      return arrayBuffer
  }
  def generateRajat(alaraja :Int, ylaraja :Int) :ArrayBuffer[Int] = {
      val arrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Int]
      var jaollinen = false
      for(i<-alaraja to ylaraja) {
        jaollinen=false
        breakable{arrayBuffer.foreach { x => if(i%x==0) {
          jaollinen = true
          break
        }}}
        if(!jaollinen) { arrayBuffer+=i }
      }
      return arrayBuffer
  }
  override def main(args: Array[String]) {
    val arrayBuffer = generateYlaraja(10)
    arrayBuffer.foreach { x => println(x) }
    val arrayBuffer2 = generate(10)
    arrayBuffer2.foreach { x => println(x) }
    val arrayBuffer3 = generateRajat(2,10)
    arrayBuffer3.foreach { x => println(x) }
  }
}