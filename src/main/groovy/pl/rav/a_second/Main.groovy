package pl.rav.a_second

import groovy.transform.Field

@Field String PATH_PROD = 'data/input.txt'
@Field String PATH_TEST = 'data/test.txt'

@Field int WIN = 6
@Field int DRAW = 3
@Field int LOST = 0

println('Main path: ' + new File(".").absolutePath)

int firstRoundScore = 0
int secondRoundScore = 0

new File(PATH_PROD).newInputStream().eachLine {
    def abc = it[0]
    def xyz = it[2]
    firstRoundScore += getGameScore(abc, xyz) + getShapeScore(xyz)
    secondRoundScore += getShapeBasedOnResult(abc, xyz)
}

println('----------------')
println("FIRST ROUND: $firstRoundScore")    // 11906
println("SECOND ROUND: $secondRoundScore")  //
println('----------------')

int getGameScore(String abc, String xyz) {
    int result = LOST
    if (abc == 'A' && xyz == 'X' || abc == 'B' && xyz == 'Y' || abc == 'C' && xyz == 'Z') result = DRAW
    if (abc == 'A' && xyz == 'Y' || abc == 'B' && xyz == 'Z' || abc == 'C' && xyz == 'X') result = WIN

    return result
}

int getShapeScore(String xyz) {
    return switch (xyz.toUpperCase()) {
        case 'X' -> 1
        case 'Y' -> 2
        case 'Z' -> 3
        default -> throw new IllegalArgumentException("Not recognised shape: ${xyz}")
    }
}

int getShapeBasedOnResult(String abc, String xyz) {
    return switch (xyz.toUpperCase()) {
        case 'X' -> LOST + getShapeScoreForLost(abc)
        case 'Y' -> DRAW + getShapeScoreForDraw(abc)
        case 'Z' -> WIN + getShapeScoreForWin(abc)
        default -> throw new IllegalArgumentException("Do not recognise state: $xyz")
    }
}

int getShapeScoreForLost(String abc) {
    return switch (abc.toUpperCase()) {
        case 'A' -> 3
        case 'B' -> 1
        case 'C' -> 2
        default -> throw new IllegalArgumentException("Do not recognise state: $abc")
    }
}

int getShapeScoreForDraw(String abc) {
    return switch (abc.toUpperCase()) {
        case 'A' -> 1
        case 'B' -> 2
        case 'C' -> 3
        default -> throw new IllegalArgumentException("Do not recognise state: $abc")
    }
}

int getShapeScoreForWin(String abc) {
    return switch (abc.toUpperCase()) {
        case 'A' -> 2
        case 'B' -> 3
        case 'C' -> 1
        default -> throw new IllegalArgumentException("Do not recognise state: $abc")
    }
}
