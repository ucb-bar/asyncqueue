Chisel Project Template
=======================

Lightweight/minimalistic version of the [Chisel template](https://github.com/ucb-bar/chisel-template).

Uses [Verilator](https://github.com/freechipsproject/chisel3#ubuntu-like-linux) for Verilog simulations by default. Edit the tester in `src/test/scala/gcd/GCDTester.scala` to remove Verilator as a backend if this is undesirable.

Contents at a glance:

* `.gitignore` - helps Git ignore junk like generated files, build products, and temporary files.
* `build.sbt` - instructs sbt to build the Chisel project
* `project/build.properties` - sets the sbt version
* `src/main/scala/gcd/GCD.scala` - GCD source file
* `src/test/scala/gcd/GCDTester.scala` - GCD tester
* `project/plugins.sbt` - enables warnings (optional)
* `scalastyle-*` - helps IDEs/code linters check for best coding practices (optional)

Feel free to rename or delete `src/main/scala/gcd/GCD.scala` and `src/test/scala/gcd/GCDTester.scala` or use them as a reference/template.

To run all tests in this design (recommended for test-driven development):

```bash
sbt test
```

To generate Verilog for a module without parameters, run `./build.sh <package> <module>`.
The package for a module is specified by the line beginning with `package` - e.g. `package gcd`.

```bash
./build.sh gcd GCD
```
