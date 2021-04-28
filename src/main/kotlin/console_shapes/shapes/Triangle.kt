package console_shapes.shapes

class Triangle(lines: Int, char: Char): Shape() {
    override val grid: Array<CharArray> = Array(lines) { row ->
        val width = (lines - 1) * 2 + 1
        val dots = row * 2 + 1
        val offset = (width - dots) / 2
        CharArray(width) { column ->
            when (column) {
                in offset until offset + dots -> char
                else -> WHITE_SPACE
            }
        }
    }
}
