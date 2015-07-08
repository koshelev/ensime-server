package org.ensime.sexp.formats

import org.ensime.sexp._

import scala.reflect.runtime.universe._

trait TypeHintSupport {
  case class TypeHint[T](hint: SexpSymbol)
  implicit def typehint[T: TypeTag]: TypeHint[T] =
    TypeHint(SexpSymbol(":" + typeOf[T].dealias.toString.replaceAll("\\.type$", "").split("(\\.|\\$)").last))

}
