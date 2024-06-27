package com.example.mypratice_alertdialog_1

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mypratice_alertdialog_1.databinding.ActivityMainBinding

//
//
//
//基本款AlertDialog，附帶視窗大小調整
//
//
//


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.btn1.setOnClickListener {
            alertDialogSet()
        }

        setContentView(binding.root)
    }
    fun alertDialogSet(){
        var myDiaplay = windowManager.defaultDisplay

        val myAlertDialog = AlertDialog.Builder(this)
            .setTitle("DialogTest1")
            .setMessage("TESTTESTTEST")
            .setPositiveButton("確定按鈕", { Dialog, which ->
                Toast.makeText(this, "確定", Toast.LENGTH_SHORT).show()
                Log.d("myTag", "setPositiveButton")
            })
            .setNegativeButton("否定按鈕", { Dialog, which ->
                Toast.makeText(this, "否定", Toast.LENGTH_SHORT).show()
                Log.d("myTag", "setNegativeButton")
            })
            .setNeutralButton("中立按鈕", {Dialog, which ->
                Toast.makeText(this, "中立", Toast.LENGTH_SHORT).show()
                Log.d("myTag", "setNeutralButton")
            }).create()
        myAlertDialog.show()

        //調整視窗大小
        myAlertDialog.window?.attributes?.apply {
            width = (myDiaplay.width * 1).toInt()
            height = (myDiaplay.height * 1).toInt()
            myAlertDialog.window?.attributes = this
        }
    }
}