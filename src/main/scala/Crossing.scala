// See LICENSE.SiFive for license details.

package freechips.asyncqueue

import chisel3._
import chisel3.util.{DecoupledIO, Decoupled, Irrevocable, IrrevocableIO, ReadyValidIO}

class CrossingIO[T <: Data](gen: T) extends Bundle {
  // Enqueue clock domain
  val enq_clock = Input(Clock())
  val enq_reset = Input(Bool()) // synchronously deasserted wrt. enq_clock
  val enq = Flipped(Decoupled(gen))
  // Dequeue clock domain
  val deq_clock = Input(Clock())
  val deq_reset = Input(Bool()) // synchronously deasserted wrt. deq_clock
  val deq = Decoupled(gen)

  override def cloneType: this.type = new CrossingIO(gen).asInstanceOf[this.type]
}

abstract class Crossing[T <: Data] extends Module {
  val io: CrossingIO[T]
}
