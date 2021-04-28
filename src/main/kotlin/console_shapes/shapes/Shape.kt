package console_shapes.shapes

abstract class Shape {

    protected companion object {
        const val WHITE_SPACE = ' '
    }

    protected abstract val grid: Array<CharArray>

    open val line: (Int) -> CharArray
        get() = {
            when {
                it in grid.indices -> grid[it]
                grid.isNotEmpty() -> CharArray(grid[0].size) { WHITE_SPACE }
                else -> charArrayOf()
            }
        }

    val size: Int
        get() = this.grid.size
}
