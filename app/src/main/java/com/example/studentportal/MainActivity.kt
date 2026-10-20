package com.example.studentportal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: экран создан")

        val etName = findViewById<EditText>(R.id.etName)
        val btnOpen = findViewById<Button>(R.id.btnOpen)
        val btnClear = findViewById<Button>(R.id.btnClear)

        btnOpen.setOnClickListener {
            val name = etName.text.toString().trim()
            if (name.isEmpty()) {
                Log.w(TAG, "Поле ввода пустое, переход не выполнен")
                etName.error = getString(R.string.error_empty_name)
                etName.requestFocus()
                return@setOnClickListener
            }
            Log.i(TAG, "Нажата кнопка «Открыть список», введено имя: $name")

            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra(ListActivity.EXTRA_NAME, name)
            startActivity(intent)
        }

        btnClear.setOnClickListener {
            Log.i(TAG, "Нажата кнопка «Очистить»")
            etName.text.clear()
        }
    }

    override fun onStart()   { super.onStart();   Log.d(TAG, "onStart") }
    override fun onResume()  { super.onResume();  Log.d(TAG, "onResume") }
    override fun onPause()   { super.onPause();   Log.d(TAG, "onPause") }
    override fun onStop()    { super.onStop();    Log.d(TAG, "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }
}
