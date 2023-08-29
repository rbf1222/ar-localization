package de.morhenn.ar_localization.extensions

/*
 원작자(author) : morhenny
 작성자(writer) : rbf1222
 날짜(data) : 2023.08.29
 수정사항(modification) : 없음(none)
 */

import java.nio.ByteBuffer

fun ByteBuffer.putShort(value: Int): ByteBuffer = putShort(value.toShort())

fun ByteBuffer.putVertex(x: Float, y: Float, z: Float): ByteBuffer {
    putFloat(x)
    putFloat(y)
    putFloat(z)
    return this
}

fun ByteBuffer.putTriangle(first: Int, second: Int, third: Int): ByteBuffer {
    putShort(first)
    putShort(second)
    putShort(third)
    return this
}
