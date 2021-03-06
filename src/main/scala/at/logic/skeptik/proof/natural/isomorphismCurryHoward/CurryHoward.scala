package at.logic.skeptik.proof.natural
package isomorphismCurryHoward

import at.logic.skeptik.expression._
import at.logic.skeptik.expression.formula.Imp
import at.logic.skeptik.judgment.{NamedE, NaturalSequent}

object CurryHoward {
  def formulaToType(formula: E): T = formula match {
    case Var(n,t) => AtomicType(n)
    case Imp(a,b) => Arrow(formulaToType(a),formulaToType(b))
  }

  def typeToFormula(t: T): E = t match {
    case AtomicType(n) => n^o 
    case Arrow(a,b) => Imp(typeToFormula(a),typeToFormula(b))
  }
  
  private def namedEToVar(namedE: NamedE) = Var(namedE.name, formulaToType(namedE.expression))
  
  private def varToNamedE(v: Var) = NamedE(v.name, typeToFormula(v.t))
  
  def apply(p: NaturalDeductionProofNode): E = p match {
    case a: Assumption => namedEToVar(a.a)
    case ImpIntro(premise, namedE) => Abs(namedEToVar(namedE),apply(premise))
    case ImpElim(leftPremise, rightPremise) => App(apply(rightPremise), apply(leftPremise))
  }

  
  def apply(term: E): NaturalDeductionProofNode = term match {
    case v: Var => {
      val n = varToNamedE(v)
      new Assumption(Set(n),n) 
    }
    case Abs(v, e) => ImpIntro(apply(e), varToNamedE(v))
    case App(f, a) => ImpElim(apply(a), apply(f))
  }
}