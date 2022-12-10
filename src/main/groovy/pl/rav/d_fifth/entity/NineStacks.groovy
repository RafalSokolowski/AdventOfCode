package pl.rav.d_fifth.entity

class NineStacks {

    public static final List CONTAINER_INDEXES = [1, 5, 9, 13, 17, 21, 25, 29, 33]

    private final List<List<String>> stacks

    NineStacks() {
        this.stacks = new LinkedList<>()

        for (i in 0..<9) {
            stacks.add(new LinkedList<String>())
        }
    }

    boolean add(String inputRow) {
        CONTAINER_INDEXES.eachWithIndex { int containerIndex, int index ->
            if (inputRow[containerIndex] != ' ') stacks.get(index).add(inputRow[containerIndex])
        }
//        switch (inputRow) {
//            case inputRow[1] != ' ': stacks.get(0).add(inputRow[1])     // 0
//            case inputRow[5] != ' ': stacks.get(1).add(inputRow[5])     // 1
//            case inputRow[9] != ' ': stacks.get(2).add(inputRow[9])     // 2
//            case inputRow[13] != ' ': stacks.get(3).add(inputRow[13])   // 3
//            case inputRow[17] != ' ': stacks.get(4).add(inputRow[17])   // 4
//            case inputRow[21] != ' ': stacks.get(5).add(inputRow[21])   // 5
//            case inputRow[25] != ' ': stacks.get(6).add(inputRow[25])   // 6
//            case inputRow[29] != ' ': stacks.get(7).add(inputRow[29])   // 7
//            case inputRow[33] != ' ': stacks.get(8).add(inputRow[33])   // 8
//        }
    }



}
