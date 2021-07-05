package com.xeyalsherif.ortalamahesablama

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

open class MainActivity : AppCompatActivity() {

    var lessonsNameArray=ArrayList<String>()
    var lessonsCreditArray=ArrayList<Int>()
    var selectNameArray=ArrayList<String>()
    var selectPointArray=ArrayList<Int>()
    lateinit var arrayNameAdapter: ArrayAdapter<String>
    lateinit var arrayCreditAdapter: ArrayAdapter<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//To Enter Names in LessonNameArray
        lessonsNameArray.add("Empty Lesson")
        lessonsNameArray.add("Lesson1")
        lessonsNameArray.add("Lesson2")
        lessonsNameArray.add("Lesson3")
        lessonsNameArray.add("Lesson4")
        lessonsNameArray.add("Lesson5")
        lessonsNameArray.add("Lesson6")


//To Enter Lessons Credit in LessonsPointArray
        lessonsCreditArray.add(0)
        lessonsCreditArray.add(3)
        lessonsCreditArray.add(4)
        lessonsCreditArray.add(5)
        lessonsCreditArray.add(6)
        lessonsCreditArray.add(7)
        lessonsCreditArray.add(8)
        lessonsCreditArray.add(9)


//NameAdapter
        arrayNameAdapter= ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,android.R.id.text1,lessonsNameArray)
//PointAdapter
        arrayCreditAdapter=ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,android.R.id.text1,lessonsCreditArray)

        //Fun call
        LessonsAndCredit()
        ButtonClick()


    }

    fun LessonsAndCredit(){
        var lessonAndHour1=CommonLesson(nameLesson1,creditLesson1,arrayNameAdapter,arrayCreditAdapter,pointLesson1,textView)
        var lessonAndHour2=CommonLesson(nameLesson2,creditLesson2,arrayNameAdapter,arrayCreditAdapter,pointLesson2,textView2)
        var lessonAndHour3=CommonLesson(nameLesson3,creditLesson3,arrayNameAdapter,arrayCreditAdapter,pointLesson3,textView3)
        var lessonAndHour4=CommonLesson(nameLesson4,creditLesson4,arrayNameAdapter,arrayCreditAdapter,pointLesson4,textView4)
        var lessonAndHour5=CommonLesson(nameLesson5,creditLesson5,arrayNameAdapter,arrayCreditAdapter,pointLesson5,textView5)
        var lessonAndHour6=CommonLesson(nameLesson6,creditLesson6,arrayNameAdapter,arrayCreditAdapter,pointLesson6,textView6)
    }


        fun ButtonClick() {

            button.setOnClickListener { click ->

                var intent = Intent(this@MainActivity, ActivityGoster::class.java)

                selectNameArray.add(lessonsNameArray[nameLesson1.selectedItemPosition])
                selectNameArray.add(lessonsNameArray[nameLesson2.selectedItemPosition])
                selectNameArray.add(lessonsNameArray[nameLesson3.selectedItemPosition])
                selectNameArray.add(lessonsNameArray[nameLesson4.selectedItemPosition])
                selectNameArray.add(lessonsNameArray[nameLesson5.selectedItemPosition])
                selectNameArray.add(lessonsNameArray[nameLesson6.selectedItemPosition])

                intent.putStringArrayListExtra("arrayName", selectNameArray)


                var credit1 = lessonsCreditArray[creditLesson1.selectedItemPosition]
                var credit2 = lessonsCreditArray[creditLesson2.selectedItemPosition]
                var credit3 = lessonsCreditArray[creditLesson3.selectedItemPosition]
                var credit4 = lessonsCreditArray[creditLesson4.selectedItemPosition]
                var credit5 = lessonsCreditArray[creditLesson5.selectedItemPosition]
                var credit6 = lessonsCreditArray[creditLesson6.selectedItemPosition]

                selectPointArray.add(textView.text.toString().toInt())
                selectPointArray.add(textView2.text.toString().toInt())
                selectPointArray.add(textView3.text.toString().toInt())
                selectPointArray.add(textView4.text.toString().toInt())
                selectPointArray.add(textView5.text.toString().toInt())
                selectPointArray.add(textView6.text.toString().toInt())

                //ders ballari
                var point1 = selectPointArray[0]
                var point2 = selectPointArray[1]
                var point3 = selectPointArray[2]
                var point4 = selectPointArray[3]
                var point5 = selectPointArray[4]
                var point6 = selectPointArray[5]

                intent.putIntegerArrayListExtra("arrayPoint", selectPointArray)

                try {
                    val creditTotal = credit1 + credit2 + credit3 + credit4 + credit5 + credit6
                    //Average
                    val average =((credit1 * point1) + (credit2 * point2) + (credit3 * point3) + (credit4 * point4) + (credit5 * point5) + (credit6 * point6)) / creditTotal
                    intent.putExtra("average", average)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                } catch (e: Exception) {
                    Snackbar.make(click,"Please enter lesson credit",Snackbar.LENGTH_LONG).show()
                }
            }
        }
}




