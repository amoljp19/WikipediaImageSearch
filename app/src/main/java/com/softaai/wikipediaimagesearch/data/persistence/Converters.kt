package com.softaai.wikipediaimagesearch.data.persistence

import androidx.room.TypeConverter
import com.softaai.wikipediaimagesearch.model.*
import com.squareup.moshi.Moshi

class Converters {

    @TypeConverter
    fun fromStringToX11903589(value: String): X11903589? =
        Moshi.Builder().build().adapter(X11903589::class.java).fromJson(value)

    @TypeConverter
    fun fromX11903589ToString(x11903589: X11903589?): String =
        Moshi.Builder().build().adapter(X11903589::class.java).toJson(x11903589)



    @TypeConverter
    fun fromStringToX13260340(value: String): X13260340? =
        Moshi.Builder().build().adapter(X13260340::class.java).fromJson(value)

    @TypeConverter
    fun fromX13260340ToString(x13260340: X13260340?): String =
        Moshi.Builder().build().adapter(X13260340::class.java).toJson(x13260340)



    @TypeConverter
    fun fromStringToX1425939(value: String): X1425939? =
        Moshi.Builder().build().adapter(X1425939::class.java).fromJson(value)

    @TypeConverter
    fun fromX1425939ToString(x1425939: X1425939?): String =
        Moshi.Builder().build().adapter(X1425939::class.java).toJson(x1425939)



    @TypeConverter
    fun fromStringToX14533(value: String): X14533? =
        Moshi.Builder().build().adapter(X14533::class.java).fromJson(value)

    @TypeConverter
    fun fromX14533ToString(x14533: X14533?): String =
        Moshi.Builder().build().adapter(X14533::class.java).toJson(x14533)



    @TypeConverter
    fun fromStringToX149333(value: String): X149333? =
        Moshi.Builder().build().adapter(X149333::class.java).fromJson(value)

    @TypeConverter
    fun fromX149333ToString(x149333: X149333?): String =
        Moshi.Builder().build().adapter(X149333::class.java).toJson(x149333)



    @TypeConverter
    fun fromStringToX161022(value: String): X161022? =
        Moshi.Builder().build().adapter(X161022::class.java).fromJson(value)

    @TypeConverter
    fun fromX161022ToString(x161022: X161022?): String =
        Moshi.Builder().build().adapter(X161022::class.java).toJson(x161022)



    @TypeConverter
    fun fromStringToX21883857(value: String): X21883857? =
        Moshi.Builder().build().adapter(X21883857::class.java).fromJson(value)

    @TypeConverter
    fun fromX21883857ToString(x21883857: X21883857?): String =
        Moshi.Builder().build().adapter(X21883857::class.java).toJson(x21883857)



    @TypeConverter
    fun fromStringToX57707(value: String): X57707? =
        Moshi.Builder().build().adapter(X57707::class.java).fromJson(value)

    @TypeConverter
    fun fromX57707ToString(x57707: X57707?): String =
        Moshi.Builder().build().adapter(X57707::class.java).toJson(x57707)


    @TypeConverter
    fun fromStringToX590246(value: String): X590246? =
        Moshi.Builder().build().adapter(X590246::class.java).fromJson(value)

    @TypeConverter
    fun fromX590246ToString(x590246: X590246?): String =
        Moshi.Builder().build().adapter(X590246::class.java).toJson(x590246)


    @TypeConverter
    fun fromStringToX7199609(value: String): X7199609? =
        Moshi.Builder().build().adapter(X7199609::class.java).fromJson(value)

    @TypeConverter
    fun fromX7199609ToString(x7199609: X7199609?): String =
        Moshi.Builder().build().adapter(X7199609::class.java).toJson(x7199609)


}