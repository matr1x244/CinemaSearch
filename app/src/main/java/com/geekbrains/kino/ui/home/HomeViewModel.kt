package com.geekbrains.kino.ui.home

import android.arch.lifecycle.*
import android.util.Log
import com.geekbrains.kino.AppState
import com.geekbrains.kino.ui.home.interactors.ImageInteractor
import java.lang.Thread.sleep

class HomeViewModel (

    private val liveDataToObserve : MutableLiveData <Any> = MutableLiveData()) : ViewModel(), LifecycleObserver {

    private val repository: Repository = RepositoryImpl()

    private val TAG = "HomeViewModel"

    fun getStartReload(): LiveData<Any> {
        Log.d(TAG, "getStartReload")
        getStart()
        return liveDataToObserve
    }

    var fabImageLiveData: MutableLiveData<Int> = MutableLiveData()

    lateinit var imageInteractor: ImageInteractor

    private var isDataSetRus: Boolean = true

    fun getLiveData() = liveDataToObserve

    fun getFromLocalStorageCinameRus() = getDataFromLocalSource(true)

    fun getFromLocalStorageCinemaWorld() = getDataFromLocalSource(false)

    fun getFromRemoteSource() = getDataFromLocalSource(true)

        private fun getStart(){ // далее прикрутить запуск загрузки базы данных фильмов
        Thread{
            Log.d(TAG, "Thread getStart")
            Thread.sleep(1000)
            liveDataToObserve.postValue("Успешное обновление")
        }.start()
    }

    fun onFABClicked(renderFabImage: Unit) {
        if (isDataSetRus) {
            getFromLocalStorageCinemaWorld()
            fabImageLiveData.postValue(imageInteractor.worldImage)
        } else {
            getFromLocalStorageCinameRus()
            fabImageLiveData.postValue(imageInteractor.rusImage)
        }
        isDataSetRus = !isDataSetRus
    }

    private fun getDataFromLocalSource(isRussian: Boolean) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(
                if (isRussian) repository.getFromLocalStorageCinameRus()
                else repository.getFromLocalStorageCinemaWorld())
            )
        }.start()
    }
        fun OnCleared() {
            super.onCleared()
        }
    }
