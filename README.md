Chisel Project Template
=======================

Lightweight/minimalistic version of the [Chisel template](https://github.com/ucb-bar/chisel-template)

Uses [Verilator](https://github.com/freechipsproject/chisel3#ubuntu-like-linux) for Verilog simulations by default. Edit the tester in `src/test/scala/gcd/GCDTester.scala` to remove Verilator as a backend if this is undesirable.

* `.gitignore` - helps Git ignore junk like generated files, build products, and temporary files.
* `build.sbt` - instructs sbt to build the Chisel project
* `project/build.properties` - sets the sbt version
* `src/main/scala/gcd/GCD.scala` - GCD source file
* `src/test/scala/gcd/GCDTester.scala` - GCD tester
* `project/plugins.sbt` - enables warnings (optional)
* `scalastyle-*` - helps IDEs/code linters check for best coding practices (optional)
