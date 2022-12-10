package pl.rav.d_fifth


import pl.rav.d_fifth.entity.NineStacks
import pl.rav.d_fifth.operations.Move
import pl.rav.d_fifth.utils.Util

NineStacks nineStacks = new NineStacks()

new File('data/input.txt').eachLine {
    if (Util.isContainerCreation(it)) {
        nineStacks.add(it)
    }

    if (Util.isCommand(it)) {
//      Move.oneByOne(it, nineStacks.stacks)    // CNSZFDVLJ
        Move.byBatches(it, nineStacks.stacks)   // QNDWLMGNS
    }
}

String result = ''
nineStacks.stacks.each { result += it[0] }
println(result)
