package com.xeyalsherif.ortalamahesablama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_goster.*

class ActivityGoster : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goster)

        var NameArray=getIntent().getStringArrayListExtra("arrayName")
        var PointArray=getIntent().getIntegerArrayListExtra("arrayPoint")
        var Average=getIntent().getIntExtra("average",0)

        name1.setText(NameArray!![0].toString())
        name2.setText(NameArray!![1].toString())
        name3.setText(NameArray!![2].toString())
        name4.setText(NameArray!![3].toString())
        name5.setText(NameArray!![4].toString())
        name6.setText(NameArray!![5].toString())

        point1.setText(PointArray!![0].toString())
        point2.setText(PointArray!![1].toString())
        point3.setText(PointArray!![2].toString())
        point4.setText(PointArray!![3].toString())
        point5.setText(PointArray!![4].toString())
        point6.setText(PointArray!![5].toString())

        ortalama.setText("You Average:$Average")
    }
    override fun onBackPressed() {

        val BackClick=Intent(this@ActivityGoster,MainActivity::class.java)
        BackClick.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(BackClick)

    }
}