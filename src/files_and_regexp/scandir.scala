package files_and_regexp

import java.io.File

object scandir extends App {
  def subdirs(dir: File): Iterator[File] = {
    val children = dir.listFiles().filter(_.isDirectory)
    children.toIterator ++ children.toIterator.flatMap(subdirs _)
  }

  val dir = new File("./")
  for (d <- subdirs(dir)) println(d)

  //  Dont have this packge
//    import java.nio.file._
//    def makeFileVisitor(f: (Path) => Unit) = new SimpleFileVisitor[Path] {
//      override def visitFile(p: Path, attrs: attributes.BasicFileAttributes) = {
//        f(p)
//        FileVisitResult.CONTINUE
//      }
//    }


//    Files.walkFileTree(dir.toPath, (f: Path) => println(f))
}
