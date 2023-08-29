package de.morhenn.ar_localization.ar

/*
 원작자(author) : morhenny
 작성자(writer) : rbf1222
 날짜(data) : 2023.08.29
 수정사항(modification) : 없음(none)
 */

import io.github.sceneview.ar.ArSceneLifecycle
import io.github.sceneview.ar.ArSceneLifecycleObserver
import io.github.sceneview.ar.node.infos.TapArPlaneInfoNode

class MyArInstructions(private val lifecycle: ArSceneLifecycle) : ArSceneLifecycleObserver {

    private val sceneView get() = lifecycle.sceneView

    var enabled = true
        set(value) {
            field = value
            infoNode?.isVisible = value
        }

    var infoNode: TapArPlaneInfoNode? = null
        set(value) {
            if (field != value) {
                field?.let { it.parent = null }
                field = value?.apply {
                    isVisible = this@MyArInstructions.enabled
                    parent = sceneView.camera
                }
                field = value
            }
        }

    var text = infoNode?.text
        set(value) {
            value?.let {
                enabled = true
                field = value
                infoNode?.text = value
            } ?: run {
                enabled = false
            }
        }

    init {
        lifecycle.addObserver(this)
    }
}
