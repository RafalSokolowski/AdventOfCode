package pl.rav.d_fifth.utils

class Util {

    static boolean isCommand(String inputLine) {
        return inputLine.contains('move')
    }

    static boolean isContainerCreation (String inputLine) {
        return inputLine != '' && !inputLine.contains(' 1') && !inputLine.contains('move')
    }

    static int count (List<List<String>> stacks) {
        int count = 0
        stacks.each {count += it.size()}

        return count
    }

}
