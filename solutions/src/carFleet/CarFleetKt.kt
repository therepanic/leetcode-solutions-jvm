package carFleet

class CarFleetKt {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val positionMap = mutableMapOf<Int, Int>()

        for (i in position.indices) {
            positionMap[position[i]] = i
        }

        position.sort()

        var leaderTime = Int.MIN_VALUE.toDouble()
        var fleetCount = 0

        for (i in position.size - 1 downTo 0) {
            val t = (target - position[i]).toDouble() / speed[positionMap[position[i]]!!]

            if (t > leaderTime) {
                fleetCount++
                leaderTime = t
            }
        }

        return fleetCount
    }
}