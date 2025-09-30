package com.example.mypratice_alertdialog_1


import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mypratice_alertdialog_1.databinding.ActivityMainBinding
import com.example.mypratice_alertdialog_1.databinding.AlertdialogViewBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCallBasicAlertDialog.setOnClickListener {
            alertDialogSet()
        }
        binding.btnCallCustomAlertDialog.setOnClickListener {
            myCustomAlertDialogSet()
        }

    }
    /**
     * 顯示標準 AlertDialog (標題、訊息、三個按鈕)。
     * 按鈕點擊後顯示 Toast 並關閉對話框。不可取消。
     */
    fun alertDialogSet(){
        AlertDialog.Builder(this@MainActivity).apply { // 使用 Activity Context
            setTitle("Test標題")
            setMessage("Test訊息")
            setPositiveButton("確定按鈕") { dialog, _ -> // "確定"按鈕
                Toast.makeText(this@MainActivity, "Yes", Toast.LENGTH_SHORT).show()
                dialog.dismiss() // 關閉
            }
            setNegativeButton("否定按鈕") { dialog, _ -> // "否定"按鈕
                Toast.makeText(this@MainActivity, "No", Toast.LENGTH_SHORT).show()
                dialog.dismiss() // 關閉
            }
            setNeutralButton("中立按鈕") { dialog, _ -> // "中立"按鈕
                dialog.dismiss() // 關閉
            }
            setCancelable(false) // 不可通過點擊外部或返回鍵取消
        }.show() // 建立並顯示
    }

    /**
     * 顯示使用自訂佈局 (alertdialog_view.xml) 的 AlertDialog。
     * 自訂佈局中的按鈕控制行為和關閉。不可取消。
     */
    fun myCustomAlertDialogSet(){
        val dialogViewBinding = AlertdialogViewBinding.inflate(layoutInflater) // 載入自訂視圖
        val myCustomAlertDialog = AlertDialog.Builder(this).apply{
            setView(dialogViewBinding.root) // 設定自訂視圖
            setCancelable(false) // 不可通過點擊外部或返回鍵取消
        }.show()

        // 自訂視圖中的 "Yes" 按鈕事件
        dialogViewBinding.btnYes.setOnClickListener {
            Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
            myCustomAlertDialog.dismiss() // 關閉
        }
        // 自訂視圖中的 "No" 按鈕事件
        dialogViewBinding.btnNo.setOnClickListener {
            Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
            myCustomAlertDialog.dismiss() // 關閉
        }
    }


}