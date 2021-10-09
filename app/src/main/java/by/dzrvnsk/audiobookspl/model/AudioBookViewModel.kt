package by.dzrvnsk.audiobookspl.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.dzrvnsk.audiobookspl.data.ApiAudiobook
import by.dzrvnsk.audiobookspl.data.Audiobook
import by.dzrvnsk.audiobookspl.data.AudiobookResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AudioBookViewModel : ViewModel() {

    private val apiAudioBook = ApiAudiobook.create().getAudiobooks()
    val audiobooksLiveData = MutableLiveData<AudiobookResponse>()
    val currentAudioBook = MutableLiveData<Audiobook>()

    init {
        apiAudioBook.enqueue(object : Callback<AudiobookResponse> {
            override fun onResponse(
                call: Call<AudiobookResponse>,
                response: Response<AudiobookResponse>
            ) {
                audiobooksLiveData.value = response.body()
            }

            override fun onFailure(call: Call<AudiobookResponse>, t: Throwable) {
            }
        })
    }

    fun setCurrentAudiobook(audiobook: Audiobook) {
        currentAudioBook.value = audiobook
    }
}