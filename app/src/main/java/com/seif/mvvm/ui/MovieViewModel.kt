package com.seif.mvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.seif.mvcproject.Pojo.MoviesModel
import kotlin.random.Random

class MovieViewModel : ViewModel() {
    // liveData can't change data manually
    val movieNameMutableLiveData: MutableLiveData<String> = MutableLiveData()
    // Mutable liveData can change data manually

    fun getMovieName() {
        val movieName: String = getMovieNameFromDatabase()
        movieNameMutableLiveData.value = movieName
    }

    private fun getMovieNameFromDatabase(): String {
        val movieList = ArrayList<MoviesModel>()
        movieList.add(MoviesModel("Ant Man", "2020", "Fantasy", 1))
        movieList.add(MoviesModel("Super Man", "2020", "Fantasy", 2))
        movieList.add(MoviesModel("Bat Man", "2020", "Fantasy", 3))
        movieList.add(MoviesModel("Aqua Man", "2020", "Fantasy", 4))
        movieList.add(MoviesModel("Wounder Woman", "2020", "Fantasy", 5))
        movieList.add(MoviesModel("Avengers", "2020", "Fantasy", 6))

        // return MoviesModel("The Walking Dead", "2010","Zombie series",1).name
        return movieList[Random.nextInt(0, 6)].name
    }
}