package pl.rav.d_fifth.operations

import lombok.AllArgsConstructor

@AllArgsConstructor
class Move {

    static void oneByOne(String moveLine, List<List<String>> stocks) {
        String[] commands = moveLine.split(' ')
        int amount = commands[1] as int
        int from = commands[3] as int - 1
        int to = commands[5] as int - 1

        for (i in 0..<amount) {
            if (stocks[from].isEmpty()) return

            List<String> stockFrom = stocks[from]
            String toBeMoved = stocks[from][0]

            stockFrom.remove(0)
            stocks[to].add(0, toBeMoved)
        }
    }

    static void byBatches(String moveLine, List<List<String>> stocks) {
        String[] commands = moveLine.split(' ')
        int amount = commands[1] as int
        int from = commands[3] as int - 1
        int to = commands[5] as int - 1

        List<String> stockFrom = stocks[from]

        List<String> toBeMoved = amount >= stockFrom.size() ?
                stockFrom :
                stockFrom.take(amount)

        stocks[from] = stockFrom.drop(amount)
        stocks[to] = toBeMoved + stocks[to]
    }

}
