package de.morhenn.ar_localization.model

/*
 원작자(author) : morhenny
 작성자(writer) : rbf1222
 날짜(data) : 2023.08.29
 수정사항(modification) : 없음(none)
 */

import com.google.android.gms.maps.model.LatLng

data class GeoPose(
    var latitude: Double,
    var longitude: Double,
    var altitude: Double,
    var heading: Double,
) {
    fun getLatLng(): LatLng {
        return LatLng(latitude, longitude)
    }

    override fun toString(): String {
        return buildString {
            append("GeoPose ")
            append(String.format("Lat: %.6f , ", latitude))
            append(String.format("Long: %.6f , ", longitude))
            append(String.format("Alt: %.3f , ", altitude))
            append(String.format("Heading: %.2f°", heading))
        }
    }
}
