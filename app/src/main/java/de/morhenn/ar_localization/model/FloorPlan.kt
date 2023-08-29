package de.morhenn.ar_localization.model

/*
 원작자(author) : morhenny
 작성자(writer) : rbf1222
 날짜(data) : 2023.08.29
 수정사항(modification) : 없음(none)
 */

data class FloorPlan(
    var name: String = "",
    var info: String = "",
    var ownerUID: String = "",
    var mainAnchor: CloudAnchor = CloudAnchor(),
    var mappingPointList: MutableList<MappingPoint> = mutableListOf(),
    var cloudAnchorList: MutableList<CloudAnchor> = mutableListOf(),
) {
    constructor(mainAnchor: CloudAnchor) : this("", "", "", mainAnchor, mutableListOf(), mutableListOf())
}
