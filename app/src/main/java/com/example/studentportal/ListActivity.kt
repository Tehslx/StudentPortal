package com.example.studentportal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "ListActivity"
        const val EXTRA_NAME = "EXTRA_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val userName = intent.getStringExtra(EXTRA_NAME) ?: "-"
        Log.d(TAG, "onCreate: получено имя пользователя $userName")

        findViewById<TextView>(R.id.tvGreeting).text = getString(R.string.greeting, userName)

        val listView = findViewById<ListView>(R.id.lvStudents)
        listView.adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, students.map { it.name }
        )

        listView.setOnItemClickListener { _, _, position, _ ->
            val student = students[position]
            Log.i(TAG, "Выбран студент: ${student.name}, средний балл ${student.average}")

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_STUDENT, student.name)
            intent.putExtra(DetailActivity.EXTRA_GRADE, student.average)
            intent.putExtra(DetailActivity.EXTRA_GRADES, student.grades)
            startActivity(intent)
        }
    }

    override fun onStart()   { super.onStart();   Log.d(TAG, "onStart") }
    override fun onResume()  { super.onResume();  Log.d(TAG, "onResume") }
    override fun onPause()   { super.onPause();   Log.d(TAG, "onPause") }
    override fun onStop()    { super.onStop();    Log.d(TAG, "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }
}
