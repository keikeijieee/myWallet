package com.example.mywallet

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAdd.setOnClickListener {
            val intent = Intent(this, Add::class.java)
            startActivityForResult(intent, REQUEST_ADD)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_ADD)
            if(resultCode == Activity.RESULT_OK){
                val _amount = data?.getStringExtra(Add.AMOUNT)
                val _type = data?.getIntExtra(Add.TYPE,1)
                val inOutLog = InOutLog(id=10, amount=_amount!!.toFloat(),type=_type!!)

                //TODO: Insert data to the DB using DAO
            }
    }

    companion object{
        const val REQUEST_ADD=1
    }
}
