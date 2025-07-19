package com.example.zentask.data.local.converter

import androidx.room.TypeConverter
import com.example.zentask.data.local.model.Recurrence


class RecurrenceConverter {

    @TypeConverter
    fun fromRecurrence(recurrence: Recurrence?): String? {
        return recurrence?.name
    }

    @TypeConverter
    fun toRecurrence(value: String?): Recurrence? {
        return value?.let {
            try {
                Recurrence.valueOf(it)
            } catch (e: IllegalArgumentException) {
                null

            }
        }
    }

}