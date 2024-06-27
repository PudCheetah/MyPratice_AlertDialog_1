package com.example.mypratice_alertdialog_1

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mypratice_alertdialog_1.databinding.ActivityMainBinding


//
//
//
//自訂AlertDialog(傳統作法)
//
//
//

class MainActivity3 : AppCompatActivity() {
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

        var display = windowManager.defaultDisplay
        val width = display.width
        val height = display.height

        //將自訂的AlertDialog佈局文件套用到AlertDialog上
        var layoutInflater = LayoutInflater.from(this)
        val alertView = layoutInflater.inflate(R.layout.my_alert_dialog, null)
        val scnBuilder = AlertDialog.Builder(this)

        scnBuilder.setView(alertView)
        val scnDialog = scnBuilder.create()
        scnDialog.show()

        //調整AlertDialog大小
        val layoutParams = scnDialog.window?.attributes
        layoutParams?.width = (width * 1).toInt()
        layoutParams?.height = (height * 1).toInt()
        scnDialog.window?.attributes = layoutParams


        //設置按鈕
        val btnYes = alertView.findViewById<Button>(R.id.btn_yes)
        val btnNo = alertView.findViewById<Button>(R.id.btn_no)
        btnYes.setOnClickListener {
            Toast.makeText(this, "是的，這是按鈕", Toast.LENGTH_SHORT).show()
        }
        btnNo.setOnClickListener {
            Toast.makeText(this, "不是，這是炸彈", Toast.LENGTH_SHORT).show()
        }
    }
}