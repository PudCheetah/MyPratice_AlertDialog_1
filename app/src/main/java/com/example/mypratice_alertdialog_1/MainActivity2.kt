package com.example.mypratice_alertdialog_1

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
//製作即使點擊了也不會關閉的AlertDialog
//
//
//

class MainActivity2 : AppCompatActivity() {
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
        var myAlertDialog = AlertDialog.Builder(this)
            .setTitle("DialogTest1")
            .setMessage("TESTTESTTEST")
            .setPositiveButton("確定按鈕", null)
            .setNegativeButton("否定按鈕", null)
            .setNeutralButton("中立按鈕", null)
            .setCancelable(false)
            .show()
        myAlertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            Toast.makeText(this, "確定", Toast.LENGTH_SHORT).show()
        }
        myAlertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener {
            Toast.makeText(this, "否定", Toast.LENGTH_SHORT).show()
            myAlertDialog.dismiss()
        }
        myAlertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setOnClickListener {
            Toast.makeText(this, "中立", Toast.LENGTH_SHORT).show()
        }
    }
}