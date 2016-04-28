import swing._
import event._

object TempConverter extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Calculator"

    object laskettava1 extends TextField { columns = 5 }
    object laskettava2 extends TextField { columns = 5 }
		object tulos extends TextField { columns = 5 }
		def summaNappi = new Button {
			text="+"
			action = Action("+") {
				val l1 = laskettava1.text.toFloat
				val l2 = laskettava2.text.toFloat
				val t = l1+l2
				tulos.text = t.toString
			}
		}
		def erotusNappi = new Button {
			text="-"
			action = Action("-") {
				val l1 = laskettava1.text.toFloat
				val l2 = laskettava2.text.toFloat
				val t = l1-l2
				tulos.text = t.toString
			}
		}
		def tuloNappi = new Button {
			text="*"
			action = Action("*") {
				val l1 = laskettava1.text.toFloat
				val l2 = laskettava2.text.toFloat
				val t = l1*l2
				tulos.text = t.toString
			}
		}
		def osamaaraNappi = new Button {
			text="/"
			action = Action("/") {
				val l1 = laskettava1.text.toFloat
				val l2 = laskettava2.text.toFloat
				val t = l1/l2
				tulos.text = t.toString
			}
		}

    contents = new FlowPanel {
      contents += laskettava1
      contents += new Label(" Muuttuja 1  =  ")
      contents += laskettava2
      contents += new Label(" Muuttuja 2")
      border = Swing.EmptyBorder(15, 10, 10, 10)
			contents += new Label("Tulos")
			contents += tulos
			contents += summaNappi
			contents += erotusNappi
			contents += tuloNappi
			contents += osamaaraNappi
    }

    listenTo(laskettava1, laskettava2)

    reactions += {
      case EditDone(`laskettava2`) =>   // !!
				
      case EditDone(`laskettava1`) =>      // !!
				
    }
  }
}
