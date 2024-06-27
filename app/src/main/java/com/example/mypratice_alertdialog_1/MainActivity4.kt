package com.example.mypratice_alertdialog_1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mypratice_alertdialog_1.databinding.ActivityMainBinding
import com.example.mypratice_alertdialog_1.databinding.MyAlertDialogBinding

//
//
//
//自訂AlertDialog(ViewBinding版優化作法)
//
//
//


class MainActivity4 : AppCompatActivity() {
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

        var alertDialogLayoutBinding = MyAlertDialogBinding.inflate(layoutInflater)
        var myAlertDialog = AlertDialog.Builder(this).setView(alertDialogLayoutBinding.root)
            .setView(alertDialogLayoutBinding.root)
            .create()
        myAlertDialog.show()

        //方案1(失敗)
        with(myAlertDialog.window?.attributes){
            this?.width = (myDiaplay.width * 1).toInt()
            this?.height = (myDiaplay.height * 1).toInt()
        }

        //方案2(成功)
//        myAlertDialog.window?.attributes?.apply {
//            width = (myDiaplay.width * 1).toInt()
//            height = (myDiaplay.height * 1).toInt()
//            myAlertDialog.window?.attributes = this
//        }

        alertDialogLayoutBinding.btnYes.setOnClickListener {
            Toast.makeText(this, "是的，這是按鈕", Toast.LENGTH_SHORT).show()
        }
        alertDialogLayoutBinding.btnNo.setOnClickListener {
            Toast.makeText(this, "不是，這是炸彈", Toast.LENGTH_SHORT).show()
        }
    }
}