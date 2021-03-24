package com.seif.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.seif.mvvm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // listening
        val movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movieViewModel.movieNameMutableLiveData.observe(this, {
            txt_moviename.text = it
        })
        // When click button we call the presenter to get the movie name from data
        btn_movieName.setOnClickListener {
            movieViewModel.getMovieName()

        }
    }
}