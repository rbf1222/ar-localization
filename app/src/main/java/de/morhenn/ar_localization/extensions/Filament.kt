package de.morhenn.ar_localization.extensions

/*
 원작자(author) : morhenny
 작성자(writer) : rbf1222
 날짜(data) : 2023.08.29
 수정사항(modification) : 없음(none)
 */

import android.content.Context
import com.google.android.filament.Engine
import com.google.android.filament.Material
import java.nio.ByteBuffer
import java.nio.channels.Channels

fun loadMaterial(context: Context, engine: Engine, name: String): Material {
    val dst: ByteBuffer

    context.assets.openFd("materials/$name").use { fd ->
        val input = fd.createInputStream()
        dst = ByteBuffer.allocate(fd.length.toInt())

        val src = Channels.newChannel(input)
        src.read(dst)
        src.close()

        dst.rewind()
    }

    return Material.Builder().payload(dst, dst.remaining()).build(engine)
}
