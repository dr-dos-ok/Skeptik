package at.logic.skeptik.algorithm.compressor

import at.logic.skeptik.proof.Proof
import at.logic.skeptik.proof.sequent.SequentProofNode
import at.logic.skeptik.proof.sequent.lk.{Axiom, R}
import at.logic.skeptik.judgment.immutable.{SeqSequent => Sequent}
import scala.collection.mutable.{HashMap => MMap}


object ReduceCore 
extends (Proof[SequentProofNode] => Proof[SequentProofNode]) {
  def apply(proof: Proof[SequentProofNode]) = {
    // use safeliterals to find out which axiom clauses are superfluous.
    // use resolution hypergraphs to find out dependencies between these axiom clauses,
    // to know which redundant clauses can be simultaneously removed.
    proof
  }
}

