package com.example.studentportal

class Student(val name: String, val grades: IntArray) {
    val average: Int get() = grades.average().toInt()
}

val students = listOf(
    Student("Асанов Айдос", intArrayOf(95, 90, 92, 91)),
    Student("Бекова Айгерим", intArrayOf(88, 94, 85, 90)),
    Student("Ержанов Даулет", intArrayOf(76, 82, 79, 80)),
    Student("Нурланова Мадина", intArrayOf(98, 96, 97, 99)),
    Student("Сериков Тимур", intArrayOf(65, 70, 72, 68)),
    Student("Тулегенова Алия", intArrayOf(84, 87, 81, 89)),
)
