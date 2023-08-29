package de.morhenn.ar_localization.model

/*
 원작자(author) : morhenny
 작성자(writer) : rbf1222
 날짜(data) : 2023.08.29
 수정사항(modification) : 없음(none)
 */

data class CloudAnchor(
    var text: String = "", //description to search by
    var floor: Int = 0, //floor level of the anchor
    var cloudAnchorId: String = "",

    //geo position of the anchor
    var lat: Double = 0.0,
    var lng: Double = 0.0,
    var alt: Double = 0.0,
    var compassHeading: Double = 0.0,

    //relative position of the anchor to current main anchor
    var xToMain: Float = 0.0f,
    var yToMain: Float = 0.0f,
    var zToMain: Float = 0.0f,
    var relativeQuaternion: SerializableQuaternion = SerializableQuaternion(),
) {
    constructor(text: String, floor: Int, cloudAnchorId: String, lat: Double, lng: Double, alt: Double, compassHeading: Double) :
            this(text, floor, cloudAnchorId, lat, lng, alt, compassHeading, 0.0f, 0.0f, 0.0f, SerializableQuaternion())

    constructor(text: String, floor: Int, cloudAnchorId: String, lat: Double, lng: Double, alt: Double, compassHeading: Double, quaternion: SerializableQuaternion) :
            this(text, floor, cloudAnchorId, lat, lng, alt, compassHeading, 0.0f, 0.0f, 0.0f, quaternion)

    constructor(text: String, floor: Int, cloudAnchorId: String, geoPose: GeoPose, quaternion: SerializableQuaternion) :
            this(text, floor, cloudAnchorId, geoPose.latitude, geoPose.longitude, geoPose.altitude, geoPose.heading, 0.0f, 0.0f, 0.0f, quaternion)

    fun getGeoPose(): GeoPose {
        return GeoPose(lat, lng, alt, compassHeading)
    }
}
