import kotlin.math.sqrt

data class Point(val x: Double, val y: Double) {
    fun distanceTo(other: Point): Double {
        val dx = x - other.x
        val dy = y - other.y
        return sqrt(dx * dx + dy * dy)
    }
}

fun main() {
    println("Введите количество точек (больше двух):")
    val pointCount = readLine()?.toIntOrNull() ?: 0
    if (pointCount < 3) {
        println("Некорректное количество точек. Введите число больше двух.")
        return
    }

    val points = mutableListOf()
    for (i in 1..pointCount) {
        println("Введите координаты точки $i (x, y):")
        val x = readLine()?.toDouble() ?: 0.0
        val y = readLine()?.toDouble() ?: 0.0
        points.add(Point(x, y))
    }

    var minDistance = Double.MAX_VALUE
    var maxDistance = 0.0
    for (i in 0 until points.size - 1) {
        for (j in i + 1 until points.size) {
            val distance = points[i].distanceTo(points[j])
            if (distance < minDistance) {
                minDistance = distance
            }
            if (distance > maxDistance) {
                maxDistance = distance
            }
        }
    }

    println("Минимальное расстояние: $minDistance")
    println("Максимальное расстояние: $maxDistance")
}
