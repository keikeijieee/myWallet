package com.example.mywallet

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.util.*

@Entity(tableName = "in_out_log")
class InOutLog(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val amount : Float,
    val type: Int, //1 = income , 0 = expenses
    val created_at : Long = System.currentTimeMillis()

)