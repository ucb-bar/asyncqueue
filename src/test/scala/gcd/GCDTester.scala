package gcd.test

import gcd._

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class GCDUnitTester(c: GCD) extends PeekPokeTester(c) {
  /**
    * Compute the gcd and the number of steps it should take to do it.
    *
    * @param a positive integer
    * @param b positive integer
    * @return the GCD of a and b, and how many steps it took
    */
  def computeGcd(a: Int, b: Int): (Int, Int) = {
    var x = a
    var y = b
    var depth = 1
    while(y > 0) {
      if (x > y) {
        x -= y
      }
      else {
        y -= x
      }
      depth += 1
    }
    (x, depth)
  }

  private val gcd = c

  for(i <- 1 to 40 by 3) {
    for (j <- 1 to 40 by 7) {
      poke(gcd.io.value1, i)
      poke(gcd.io.value2, j)
      poke(gcd.io.loadingValues, 1)
      step(1)
      poke(gcd.io.loadingValues, 0)

      val (expected_gcd, steps) = computeGcd(i, j)

      step(steps - 1) // -1 is because we step(1) already to toggle the enable
      expect(gcd.io.outputGCD, expected_gcd)
      expect(gcd.io.outputValid, 1)
    }
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * testOnly example.test.GCDTester
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'testOnly example.test.GCDTester'
  * }}}
  */
class GCDTester extends ChiselFlatSpec {
  // Disable this until we fix isCommandAvailable to swallow stderr along with stdout
  private val backendNames = Array("firrtl", "verilator")
  for ( backendName <- backendNames ) {
    "GCD" should s"calculate proper greatest common denominator (with $backendName)" in {
      Driver(() => new GCD, backendName) {
        c => new GCDUnitTester(c)
      } should be (true)
    }
  }
}
