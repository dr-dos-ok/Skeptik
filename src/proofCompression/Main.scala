/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proofCompression


import scala.collection.mutable._
import proofCompression.Utilities._
import proofCompression.ResolutionCalculus._
import proofCompression.Hypergraph._
import proofCompression.GUI._
import proofCompression.ProofRegularization._
import proofCompression.ProofDAGification._
import proofCompression._
import evaluation._

object Main {
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {

//    val gui = new HypergraphVisualizer
//    gui.displayHypergraph(g3)
//

//    val writer = new FileWriter("myfile2.test")
//    writer.write("hello world", 7, 1)
//    writer.close

    val directory = "proofs/BWPProofs/"
    val proofFiles = List(//"ContractionAndSplittingCase1",
                          //"ContractionAndSplittingCase2",
                          //"ContractionAndSplittingCase3"
                          //"TheFirstChallenge1",
                          //"TheFirstChallenge",
                          //"pigeon(3)(2)",
                          //"DAGifiableTree",
                          //"SMT2010",
                          //"irregularWithProblematicLiterals",
                          //"irregularWithoutProblematicLiterals",
                          //"simple"
                          "TheFirstChallenge2"
                          )

    val directory2 = "proofs/PascalProofs/"
    val proofFilesAim = List("50-1_6-no-1",
                             "50-1_6-no-2",
                             "50-1_6-no-3",
                             "50-1_6-no-4",
                             "50-2_0-no-1",
                             "50-2_0-no-2",
                             "50-2_0-no-3",
                             "50-2_0-no-4",
                             "100-1_6-no-1",
                             "100-1_6-no-2",
                             "100-1_6-no-3",
                             "100-1_6-no-4",
                             "100-2_0-no-1",
                             "100-2_0-no-2",
                             "100-2_0-no-3",
                             "100-2_0-no-4",
                             "200-1_6-no-1",
                             "200-1_6-no-2",
                             "200-1_6-no-3",
                             "200-1_6-no-4",
                             "200-2_0-no-1",
                             "200-2_0-no-2",
                             "200-2_0-no-3",
                             "200-2_0-no-4"
                          ).map(s => "aim-" + s)

    val proofFilesPigeonHole = List("6",
                             "7",
                             "8",
                             "9"
                          ).map(s => "hole" + s)

    val proofFilesJNH = List("2",
                             "3",
                             "4",
                             "5",
                             "6",  // runs for quite some time
                             "8",
                             "9",
                             "10",
                             "11",
                             "13",
                             "14",
                             "15",
                             //"16", // Stack Overflow after almost 10 minutes
                             "18",
                             "19",
                             "20",
                             "202",
                             "203",
                             //"206", // Stack Overflow after about 5 minutes
                             //"208", // Stack Overflow after about 6 minutes
                             "211",
                             "214",
                             "215",
                             "216",
                             "219",
                             "302",
                             "303",
                             "304",
                             "305",
                             // "306", // Stack Overflow after about 6 minutes
                             "307",
                             "308",
                             "309",
                             "310"
                          ).map(s => "jnh" + s)

    val proofFilesBF = List("0432-007",
                             "1355-075",
                             "1355-638",
                             "2670-001"
                          ).map(s => "bf" + s)

    val proofFilesPret = List("60_25",
                              "60_40",
                              "60_60",
                              "60_75"
                              //"150_25",
                              //"150_40",
                              //"150_60",
                              //"150_75"
                          ).map(s => "pret" + s)

    val proofFilesSSA = List("0432-003",
                             "2670-130",
                             //"2670-141",  Runs for too long... I interrupted after 13minutes...
                             "6288-047"
                          ).map(s => "ssa" + s)

    Experimenter.run(directory2, proofFilesAim, "outputAim20101223.txt")
    //Experimenter.run(directory2, proofFilesPigeonHole, "outputPigeon20101208.txt")
    Experimenter.run(directory2, proofFilesJNH, "outputJNH20101223.txt")
    //Experimenter.run(directory2, proofFilesBF, "outputBF20101208.txt")
    //Experimenter.run(directory2, proofFilesPret, "outputPret20101208.txt")
    //Experimenter.run(directory2, proofFilesSSA, "outputSSA20101208.txt")
    //Experimenter.runHypergraph(directory2, proofFilesAim, "outputAimHypergraph20101208.txt")
    //Experimenter.runHypergraph(directory, proofFiles, "output.txt")
   


      //for (p <- List("proofs/BWPProofs/DAGifiableTree.proof").map(file => ProofParser.getProofFromFile(file))) {
      //for (p <- List("proofs/BWPProofs/pigeon(3)(2).proof").map(file => ProofParser.getProofFromFile(file))) {
      //for (p <- List("proofs/PascalProofs/TheFirstChallenge.proof").map(file => ProofParser.getProofFromFile(file))) {
//      for (p <- List("proofs/PascalProofs/TheFirstChallenge2.proof", "proofs/BWPProofs/pigeon(3)(2).proof").map(file => ProofParser.getProofFromFile(file))) {
//
//
//
//        println(p)
//        println("Proof Length:" + proofLength(p))
//        println("Is regular? : " + isRegular(p))
//        println("Is DAG? : " + isNonTree(p))
//        regularize(p)
//        println("Regularized Proof Length:" + proofLength(p))
//        fixProof(p)
//        println("Fixed Proof Length:" + proofLength(p))
//        println("Is regular? : " + isRegular(p))
//        DAGify(p)
//        println("DAGified Proof Length:" + proofLength(p))
//        println("Final Clause :" + p.clause)
//        println()
//      }

//    val g4 = new ResolutionHypergraph(PigeonProof.clempty)
//
//    println("INITIAL GRAPH:")
//    println(g4)
//
//    g4.simplify
//
//    println("FINAL RESULT:")
//    println(g4)
//
//    println(proofLength(PigeonProof.clempty))
//
//
//
//    val g3 = new ResolutionHypergraph(Proof2.clempty)
//
//
//
//    println("INITIAL GRAPH:")
//    println(g3)
//
//    g3.simplify
//
//    println("FINAL RESULT:")
//    println(g3)
//
//    println(proofLength(Proof2.clempty))
//

//    val g2 = new ResolutionHypergraph(P4.cl1115)
//    val g2 = new ResolutionHypergraph(P4.cl1116)
//    val g2 = new ResolutionHypergraph(P4.cl1138) Solved
//    val g2 = new ResolutionHypergraph(P4.cl1139) Solved
//    val g2 = new ResolutionHypergraph(P4.cl1140) Solved

//    val g2 = new ResolutionHypergraph(P4.cl1141) // Hard

//    val g2 = new ResolutionHypergraph(P4.cl1142) Solved
//    val g2 = new ResolutionHypergraph(P4.cl1143) Solved

//    val g2 = new ResolutionHypergraph(P4.cl1144) Solved
    //
//    val g2 = new ResolutionHypergraph(P4.cl1145) Solved from 1145 to 1148

//    val g2 = new ResolutionHypergraph(P4.cl1149) Solved until 1154

//    val f = P4.cl1155

    //val f = P4.cl1180
//    val g2 = new ResolutionHypergraph(f)

//    val g2 = new ResolutionHypergraph(P4.cl1200)
//    val g2 = new ResolutionHypergraph(P4.cl1200)
//    val g2 = new ResolutionHypergraph(P4.cl1200)
//    val g2 = new ResolutionHypergraph(P4.cl1170)
//    val g2 = new ResolutionHypergraph(P4.cl1200)
//    val g2 = new ResolutionHypergraph(P4.clempty)


//    val f = Proof0.c8
//    val g = new ResolutionHypergraph(f)
//
//    val gui = new HypergraphVisualizer
//    gui.displayHypergraph(g)
//
//    println("INITIAL GRAPH:")
//    println(g)
//////
//    g.simplify
//////
//    println("FINAL RESULT:")
//    println(g)
//////
//    println(proofLength(f))

    
  }
}
