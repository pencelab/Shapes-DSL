package console_shapes.shapes

object Space: Shape() {
    private const val WIDTH = 3

    override val grid: Array<CharArray>
        get() = emptyArray()

    override val line: (Int) -> CharArray
        get() = {
            CharArray(WIDTH) { WHITE_SPACE }
        }
}