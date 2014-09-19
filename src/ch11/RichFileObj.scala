package ch11

import java.io.File

class RichFile(filePath: String) {
  val file = new File(filePath)

  override def toString = f"RichFile($filePath)"
}

object RichFile {
  def apply(path: String) = new RichFile(path)

  def unapply(rf: RichFile) = {
    if (rf == null || rf.file.getAbsolutePath.isEmpty) None
    else {
      val basename = rf.file.getName
      val dirname = rf.file.getParent
      val (name, ext) = basename.split("\\.", 2) match {
        case Array(name, ext) => (name, ext)
        case Array(name) => (name, "")
      }
      Some((dirname, name, ext))
    }
  }
}

object RichFilePath {
  def unapplySeq(rf: RichFile): Option[Seq[String]] = {
    val filePath = rf.file.getAbsolutePath
    if (filePath.isEmpty) None
    else Some(filePath.split("/"))
  }
}

object --> {
  def unapply(rf: RichFile): Option[(RichFile, String)] = {
    if (rf.file.getAbsolutePath.isEmpty)
      None
    else {
      val f = rf.file.getAbsoluteFile
      Some((RichFile(f.getParent), f.getName))
    }
  }
}

object RichFileObj extends App {
  val l = List(
    RichFile("/abc/def/name.txt"),
    RichFile("/home/cay/name.txt"),
    RichFile("/a/b/c/d/e"),
    RichFile("/y/z"))

  l.foreach {
    case RichFilePath(a, b, c) => println("RichFilePath -> " +(a, b, c))
    case RichFile(f) => println("RichFile -> " + f)
  }

  l.foreach {
    case a --> b --> c => println(f"$a\t$b\t$c")
    case a --> b => println(f"$a\t$b")
    case a => println(f"$a")
  }
}
