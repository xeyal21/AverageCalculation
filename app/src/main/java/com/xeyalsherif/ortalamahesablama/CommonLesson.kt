package com.xeyalsherif.ortalamahesablama

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.*
import android.content.Intent as Intent

class CommonLesson(
                   var nameLesson:Spinner,
                   var creditLesson:Spinner,
                   var nameLessonAdapter:ArrayAdapter<String>,
                   var hourLessonAdapter:ArrayAdapter<Int>,
                   var SeekBarPoint:SeekBar,
                   var textView: TextView
                   )
{
    init {
        //Spinner connect ArrayAdapter
      nameLesson.adapter=nameLessonAdapter
      creditLesson.adapter=hourLessonAdapter


          //SeekBar:textView add onProgressChanged

 SeekBarPoint.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        textView.setText(progress.toString())

    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
})


    }
}