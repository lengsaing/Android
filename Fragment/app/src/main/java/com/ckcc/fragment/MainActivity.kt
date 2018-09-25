package com.ckcc.fragment

import android.support.v4.app.Fragment

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ckcc.fragment.fragments.ExampleFragment
import com.ckcc.fragment.fragments.ImageFragment
import com.ckcc.fragment.fragments.ItemFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ExampleFragment.OnFragmentInteractionListener {

    var arr = arrayListOf(ExampleFragment.newInstance("Leng", 19), ItemFragment(), ImageFragment())
    var count = 0

    override fun onButtonClick(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, arr.get(count))
                .commit()
        count++
        if(count >= arr.size){
            count = 0
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn1.setOnClickListener {
            //send activity in fragment using newInstance
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, arr.get(count))
                    .commit()
            count--
            if(count <= -1){
                count = arr.lastIndex
            }
        }

        btn2.setOnClickListener{
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, arr.get(count))
                    .commit()
            count++
            if(count >= arr.size){
                count = 0
            }
        }
    }

}
