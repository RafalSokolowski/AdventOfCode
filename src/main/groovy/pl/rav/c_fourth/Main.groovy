package pl.rav.c_fourth

import groovy.transform.Field

/**
 * Assumptions (no need to check):
 * - only two sections per line, '-' as range delimiter
 * */

@Field final String TEST_DATA = 'data/test.txt'
@Field final String PROD_DATA = 'data/input.txt'

@Field final String SECTIONS_DELIMITER = ','
@Field final String RANGE_DELIMITER = '-'

int counterFullyOverlapping = 0
int counterNotOverlapping = 0
int size = 0

new File(PROD_DATA).eachLine {
    String[] sections = it.split(SECTIONS_DELIMITER)

    boolean areFullyOverlapped = areSectionsFullyOverlapping(sections[0], sections[1])
    boolean areNotOverlapped = areSectionsNotOverlapping(sections[0], sections[1])

    if (areFullyOverlapped) counterFullyOverlapping++
    if (areNotOverlapped) counterNotOverlapping++

    size++
}

println("First part: $counterFullyOverlapping")             // 305
println('Second part: ' + (size - counterNotOverlapping))   // 811

private boolean areSectionsFullyOverlapping(String first, String second) {
    int[] firstSplit = first.split(RANGE_DELIMITER).collect { it as int }
    int[] secondSplit = second.split(RANGE_DELIMITER).collect { it as int }

    return firstSplit[0] <= secondSplit[0] && firstSplit[1] >= secondSplit[1] ||
            firstSplit[0] >= secondSplit[0] && firstSplit[1] <= secondSplit[1]
}

private boolean areSectionsNotOverlapping(String first, String second) {
    int[] firstSplit = first.split(RANGE_DELIMITER).collect { it as int }
    int[] secondSplit = second.split(RANGE_DELIMITER).collect { it as int }

    return firstSplit[1] < secondSplit[0] || firstSplit[0] > secondSplit[1]
}