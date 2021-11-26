package com.example.weather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import com.example.weather.databinding.FragmentWeatherBinding
import com.example.weather.models.WeatherDataClass
import com.example.weather.mvp.BaseFragmentMvp
import org.koin.android.ext.android.inject

private lateinit var binding: FragmentWeatherBinding

class WeatherFragment : BaseFragmentMvp<WeatherContract.View,
        WeatherContract.Presenter>(), WeatherContract.View {
    ///////экземпляр презентера
    override val presenter: WeatherPresenter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //////чтение в реальном времени
        binding.cityEditText.doAfterTextChanged {
            presenter.loadWeather(binding.cityEditText.text.toString())
        }
    }

    override fun getWeatherFromView(item: WeatherDataClass) {
        binding.description.text = "Описание"
        binding.country.text = "Страна"
        binding.windSpeed.text = "Скорость ветра"
        binding.clouds.text = "Облака"
        binding.lat.text = "Долгота"
        binding.lon.text = "Широта"

        val data1 = item.weather.toList()
        val data2 = data1.firstOrNull()
        binding.descriptionTextView.text = data2!!.description
        binding.tempTextView.text = item.main.temp.toString()
        binding.cloudsTextView.text = item.clouds.all.toString()
        binding.latTextView.text = item.coord.lat.toString()
        binding.lonTextView.text = item.coord.lon.toString()
        binding.windSpeedTextView.text = item.wind.speed.toString()
        binding.countryTextView.text = item.sys.country
    }
}


//    private val api: RetrofitService =
//        RetrofitClient.getClient().create(RetrofitService::class.java)

//val key = getString(R.string.weatherApiKey)
//val units = "metric"
//val lang = "ru"
//binding.btnShowWeather.setOnClickListener {
//
//    api.getWeatherList(
//        city = binding.cityEditText.text.toString(),
//        key,
//        units,
//        lang
//    ).enqueue(object : Callback<WeatherDataClass> {
//        @SuppressLint("SetTextI18n")
//        override fun onResponse(
//            call: Call<WeatherDataClass>,
//            response: Response<WeatherDataClass>,
//        ) {
//            if (response.isSuccessful && response.body() != null) {
//                val data = response.body()!!
//                binding.description.text = "Описание"
//                binding.country.text = "Страна"
//                binding.windSpeed.text = "Скорость ветра"
//                binding.clouds.text = "Облака"
//                binding.lat.text = "Долгота"
//                binding.lon.text = "Широта"
//
//                val data1 = data.weather.toList()
//                val data2 = data1.firstOrNull()
//                binding.descriptionTextView.text = data2!!.description
//                binding.tempTextView.text = data.main.temp.toString() + " ℃"
//                binding.cloudsTextView.text = "min " + data.clouds.all.toString()
//                binding.latTextView.text = "lat " + data.coord.lat.toString()
//                binding.lonTextView.text = "lon " + data.coord.lon.toString()
//                binding.windSpeedTextView.text = "wind speed " + data.wind.speed.toString()
//                binding.countryTextView.text = "county " + data.sys.country
//
//            } else {
//                Toast.makeText(
//                    requireContext(),
//                    "Введите верно город или через дефис",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//
//        override fun onFailure(call: Call<WeatherDataClass>, t: Throwable) {
//            Log.e("Error", "Error getting weather", t)
//            Toast.makeText(
//                requireActivity(),
//                "Something wrong, ${t.message}",
//                Toast.LENGTH_LONG
//            ).show()
//        }
//
//    })
//}



