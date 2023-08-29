package de.morhenn.ar_localization.ar

/*
 원작자(author) : morhenny
 작성자(writer) : rbf1222
 날짜(data) : 2023.08.29
 수정사항(modification) : 없음(none)
 */

import android.view.View.*

enum class ArMappingStates(
    val progressBarVisibility: Int = INVISIBLE,
    val fabEnabled: Boolean = false,
    val fabConfirmVisibility: Int = INVISIBLE,
    val anchorCircleEnabled: Boolean = false,
    val fabState: ArMappingFabState = ArMappingFabState.PLACE,
    val undoVisibility: Int = INVISIBLE,
) {
    NOT_INITIALIZED,
    PLACE_ANCHOR(fabEnabled = true, anchorCircleEnabled = true, undoVisibility = VISIBLE, fabState = ArMappingFabState.PLACE),
    SCAN_ANCHOR_CIRCLE(anchorCircleEnabled = true, undoVisibility = VISIBLE),
    HOSTING(progressBarVisibility = VISIBLE, anchorCircleEnabled = true, undoVisibility = VISIBLE, fabState = ArMappingFabState.HOST),
    MAPPING(fabEnabled = true, undoVisibility = VISIBLE, fabState = ArMappingFabState.NEW_ANCHOR, fabConfirmVisibility = VISIBLE),
}

enum class ArLocalizingStates(
    val progressBarVisibility: Int = INVISIBLE,
    val cancelButtonVisibility: Int = GONE,
) {
    NOT_INITIALIZED(cancelButtonVisibility = GONE),
    RESOLVING(progressBarVisibility = VISIBLE, cancelButtonVisibility = VISIBLE),
    TRACKING(cancelButtonVisibility = GONE),
    NAVIGATING(cancelButtonVisibility = GONE),
}

enum class ArResolveModes(
) {
    AUTO,
    GEOSPATIAL,
    FLOOR,
    ANCHOR,
    NONE,
}

enum class ArMappingFabState {
    PLACE,
    HOST,
    NEW_ANCHOR,
}

enum class ModelName {
    DEBUG_CUBE,
    AXIS,
    BALL,
    GEO_ANCHOR,
    ANCHOR_RESOLVED,
    ANCHOR_TRACKING_PREVIEW,
    NAV_BALL,
    NAV_TARGET,
}