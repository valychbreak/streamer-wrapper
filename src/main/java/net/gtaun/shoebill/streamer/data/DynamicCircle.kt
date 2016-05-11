package net.gtaun.shoebill.streamer.data

import net.gtaun.shoebill.`object`.Player
import net.gtaun.shoebill.data.Location
import net.gtaun.shoebill.streamer.Functions

/**
 * Created by Valeriy on 18/4/2016.
 */
class DynamicCircle(id: Int, player: Player?) : DynamicArea(id, player) {
    internal companion object {
        @JvmOverloads
        @JvmStatic
        fun create(location: Location, size: Float, player: Player? = null): DynamicCircle {
            val playerId = if (player == null) -1 else player.id

            val circle = Functions.createDynamicCircle(location, size, playerId)
            areas.add(circle)
            return circle
        }
    }
}
