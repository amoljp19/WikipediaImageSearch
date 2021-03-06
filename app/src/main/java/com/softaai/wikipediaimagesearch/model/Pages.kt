package com.softaai.wikipediaimagesearch.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.softaai.wikipediaimagesearch.model.Pages.Companion.TABLE_NAME
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = TABLE_NAME)
@JsonClass(generateAdapter = true)
data class Pages(
    @PrimaryKey
    var id:Int = 0,
    @Json(name = "11903589")
    val x11903589: X11903589?,
    @Json(name = "13260340")
    val x13260340: X13260340?,
    @Json(name = "1425939")
    val x1425939: X1425939?,
    @Json(name = "14533")
    val x14533: X14533?,
    @Json(name = "149333")
    val x149333: X149333?,
    @Json(name = "161022")
    val x161022: X161022?,
    @Json(name = "21883857")
    val x21883857: X21883857?,
    @Json(name = "57707")
    val x57707: X57707?,
    @Json(name = "590246")
    val x590246: X590246?,
    @Json(name = "7199609")
    val x7199609: X7199609?
)
{
    companion object {
        const val TABLE_NAME = "pages"
    }
}