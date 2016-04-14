

object alkuluvutApp extends App {
  import scala.collection.mutable.ArrayBuffer;
  import scala.util.control.Breaks._;
    def generate(ylaraja :Int) :ArrayBuffer[Int] = {
      val arrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Int]
      val booleanBuffer = scala.collection.mutable.ArrayBuffer.empty[Boolean]
      
      arrayBuffer+=(2);
      arrayBuffer+=(3);
      arrayBuffer+=(5);
      var sieveSize = 0
      if(ylaraja%60==0) {
        sieveSize = ylaraja
      } else {
        sieveSize = (ylaraja/60+1)*60
      }
      for(i <- 1 to sieveSize) {
        booleanBuffer+=false;
      }
      for(i <- 2 to sieveSize) {
         if(i%60 == 1 || i%60 == 13 || i%60 == 17 || i%60 == 29 || i%60 == 37 || i%60 == 41 || i%60 == 49
             || i%60 == 53) {
           breakable { for(j <- 1 to sieveSize) {
             for(k <- 0 to sieveSize/2) {
               if((4*j*j + (1+2*k)*(1+2*k))== i) {
                 if(booleanBuffer(i)) {
                   booleanBuffer(i)=false
                 } else {
                   booleanBuffer(i)=true
                 }
                 break
               }
             }
           }}         
         }
         if(i%60 == 7 || i%60 == 19 || i%60 == 31 || i%60 == 43) {
           breakable { for(j <- 1 to sieveSize) {
             for(k <- 0 to sieveSize/2) {
//               if(i==7) {println("j:"+j+", k="+k+", 3j^2+(1+2k)^2:"+(3*j*j + (1+2*k)*(1+2*k)))}
               if((3*j*j + (1+2*k)*(1+2*k))== i) {
                 if(booleanBuffer(i)) {
                   booleanBuffer(i)=false
                 } else {
                   booleanBuffer(i)=true
                   println(i+" muutettu trueksi")
                 }
                 break
               }
             }
           }}         
         }
         if(i%60 == 11 || i%60 == 23 || i%60 == 47 || i%60 == 59) {
           breakable { for(j <- 1 to sieveSize) {
             for(k <- 0 to (j-1)/2) {
               if((3*j*j - (1+2*k)*(1+2*k))== i && j>(1+2*k)) {
                 if(booleanBuffer(i)) {
                   booleanBuffer(i)=false
                 } else {
                   booleanBuffer(i)=true
                 }
                 break
               }
             }
           }}         
         }
      }
      var kaikkiLoytynyt = false
      while(kaikkiLoytynyt) {
        var pieninListassa = booleanBuffer.indexOf(true)
        var nelio = pieninListassa*pieninListassa
        arrayBuffer+=pieninListassa
        for(i<-1 to ylaraja/nelio) {
          booleanBuffer(nelio*i)=false
        }
      }
      arrayBuffer
   }
  override def main(args: Array[String]) {
    val arrayBuffer = generate(10)
    arrayBuffer.foreach { x => println(x) }
  }
}