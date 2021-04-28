package console_shapes.shapes

class Rhombus(lines: Int, char: Char): Shape() {
    override val grid: Array<CharArray> = Array(lines) { row ->
        val center = lines / 2
        val width = center * 2 + 1
        val dots = if (row < center) row * 2 + 1 else ((lines - 1) - row) * 2 + 1
        val offset = (width - dots) / 2
        CharArray(width) { column ->
            when (column) {
                in offset until offset + dots -> char
                else -> WHITE_SPACE
            }
        }
    }
}
