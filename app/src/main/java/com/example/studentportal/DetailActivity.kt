package com.example.studentportal

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "DetailActivity"
        const val EXTRA_STUDENT = "EXTRA_STUDENT"
        const val EXTRA_GRADE = "EXTRA_GRADE"
        const val EXTRA_GRADES = "EXTRA_GRADES"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val student = intent.getStringExtra(EXTRA_STUDENT) ?: "-"
        val grade = intent.getIntExtra(EXTRA_GRADE, 0)
        val grades = intent.getIntArrayExtra(EXTRA_GRADES) ?: IntArray(0)
        Log.d(TAG, "onCreate: получены данные: $student, средний балл $grade")

        findViewById<TextView>(R.id.tvStudentName).text = student
        findViewById<TextView>(R.id.tvGrade).text = getString(R.string.grade_average, grade)

        val subjects = resources.getStringArray(R.array.subjects)
        findViewById<TextView>(R.id.tvSubjects).text = subjects
            .zip(grades.toList())
            .joinToString("\n") { (subject, mark) -> getString(R.string.subject_line, subject, mark) }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            Log.i(TAG, "Нажата кнопка «Назад»")
            finish()
        }
    }

    override fun onStart()   { super.onStart();   Log.d(TAG, "onStart") }
    override fun onResume()  { super.onResume();  Log.d(TAG, "onResume") }
    override fun onPause()   { super.onPause();   Log.d(TAG, "onPause") }
    override fun onStop()    { super.onStop();    Log.d(TAG, "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }
}
