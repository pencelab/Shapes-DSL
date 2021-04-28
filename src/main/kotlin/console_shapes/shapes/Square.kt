package console_shapes.shapes

class Square(lines: Int, char: Char): Shape() {
    override val grid: Array<CharArray> = Array(lines) {
        CharArray(lines) { char }
    }
}
