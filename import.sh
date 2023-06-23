#!/bin/bash
# Helper script to update this from master rocket-chip.
set -ex

rm -rf rocket-chip
git clone https://github.com/freechipsproject/rocket-chip.git --depth 1

cd rocket-chip
git rev-parse HEAD > rocket-chip-revision.txt
mv rocket-chip-revision.txt ..
cd ..

cp rocket-chip/src/main/scala/util/AsyncQueue.scala src/main/scala
cp rocket-chip/src/main/scala/util/Crossing.scala src/main/scala
cp rocket-chip/src/main/scala/util/ShiftReg.scala src/main/scala
cp rocket-chip/src/main/scala/util/AsyncResetReg.scala src/main/scala
cp rocket-chip/src/main/scala/util/SynchronizerReg.scala src/main/scala
cp rocket-chip/src/main/scala/util/CompileOptions.scala src/main/scala
mkdir -p src/main/resources/vsrc
cp rocket-chip/src/main/resources/vsrc/AsyncResetReg.v src/main/resources/vsrc/
pushd src/main/scala
sed -i "s/package freechips.rocketchip.util/package freechips.asyncqueue/g" *
sed -i "s/import freechips.rocketchip.util.CompileOptions.NotStrictInferReset//g" *
popd
