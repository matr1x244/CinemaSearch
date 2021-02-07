package com.geekbrains.kino.ui.home

import android.arch.lifecycle.*
import android.util.Log
import java.lang.Thread.sleep

class HomeViewModel(private val liveStartReload : MutableLiveData <Any> = MutableLiveData()) : ViewModel(), LifecycleObserver {

    private val repository: RepositoryCinema = RepositoryImplCinema()
    private val TAG = "HomeViewModel"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun OnCreateCinemaNews(){
        Log.d(TAG, "OnCreateCinemaNews")
        getCinemaFromLocalStorage()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START) // цикл жизни (запуска например..)
    private fun onStart(){
        Log.d(TAG, "Lifecycle.Event.ON_START")
        liveStartReload.value = "Загружаем новые фильмы"
    }

    fun getStartReload(): LiveData<Any> {
        Log.d(TAG, "getStartReload")
        getStart()
        return liveStartReload
    }

     fun getCinemaFromServer () = getDataFromLocalStorage ()
     fun getCinemaFromLocalStorage() = getDataFromLocalStorage()

    private fun getDataFromLocalStorage() {
        Thread {
            sleep(1000)
            liveStartReload.postValue(repository.getCinemaFromLocalStorage()) // вывести пока что сообщение что поток этот запущен
        }.start()
    }

        private fun getStart(){ // далее прикрутить запуск загрузки базы данных фильмов
        Thread{
            Log.d(TAG, "Thread getStart")
            Thread.sleep(1000)
            liveStartReload.postValue("Успешное обновление")
        }.start()
    }

        fun OnCleared() {
            super.onCleared()
        }
    }
