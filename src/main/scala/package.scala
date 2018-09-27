// See LICENSE.SiFive for license details.
// This file is a selection of implicits used in AsyncQueue.

package freechips

import Chisel._

package object asyncqueue {
  implicit class SeqToAugmentedSeq[T <: Data](val x: Seq[T]) extends AnyVal {
    def asUInt(): UInt = Cat(x.map(_.asUInt).reverse)
  }

  implicit class UIntToAugmentedUInt(val x: UInt) extends AnyVal {
    def padTo(n: Int): UInt = {
      require(x.getWidth <= n)
      if (x.getWidth == n) x
      else Cat(UInt(0, n - x.getWidth), x)
    }
  }

  implicit class IntToAugmentedInt(val x: Int) extends AnyVal {
    // exact log2
    def log2: Int = {
      require(isPow2(x))
      log2Ceil(x)
    }
  }

  implicit class BooleanToAugmentedBoolean(val x: Boolean) extends AnyVal {
    // this one's snagged from scalaz
    def option[T](z: => T): Option[T] = if (x) Some(z) else None
  }
}
