package pl.rav.b_third

import groovy.transform.Field

/**
 * NO CHECKERS FOR
 * Assume (1) :
 * no empty, null or line.length % 2 != 0 strings
 * Assume (2) add :
 * all data % 3 == 0
 * */

@Field final String TEST_DATA = 'data/test.txt'
@Field final String PROD_DATA = 'data/input.txt'

@Field final int UPPERCASE_OFFSET = 38
@Field final int LOWERCASE_OFFSET = 96

int priority = 0

new File(PROD_DATA).eachLine {
    int halfLength = it.size() / 2
    int a = getCommonChar(it.substring(0, halfLength), it.substring(halfLength))
    priority += getPriority(a)
}
println("First part of the puzzle: $priority") // 8139

priority = 0
//String[] elvesGroup = new String[3]
List<String> elvesGroup = new ArrayList<>()

new File(PROD_DATA).eachLine { String string, int index ->
    elvesGroup.add(string)

    if (index % 3 == 0) {
        char a = getCommonChar(*elvesGroup)
        priority += getPriority(a as int)
        elvesGroup.clear()
    }
}

println("Second part of the puzzle: $priority") // 2668

private char getCommonChar(String... strings) {
//    if (strings.length != 3) throw new IllegalArgumentException("Elves r divided into groups of three, not: " + strings.length)
    Set<Character> c1 = getCommonChars(strings[0], strings[1])
    Set<Character> c2 = getCommonChars(strings[0], strings[2])

    return c1.find { c2.contains(it) }
}

private int getCommonChar(String first, String second) {
    return first.chars().find {
        char c = it as char
        second.contains(c as String)
    } as int
}

private Set<Character> getCommonChars(String first, String second) {
    Set<Character> result = new HashSet<>()

    first.chars().each {
        char c = it as char
        if (second.contains(c as String)) result.add(c)
    }

    return result
}

private int getPriority(int charAsInt) {
    return charAsInt > LOWERCASE_OFFSET ?
            charAsInt - LOWERCASE_OFFSET :
            charAsInt - UPPERCASE_OFFSET
}
