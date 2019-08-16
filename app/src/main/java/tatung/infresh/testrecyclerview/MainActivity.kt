package tatung.infresh.testrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listFragment : Fragment = ListFragment()

    var threeDayForecast = mutableListOf<Weather>(
        Weather("Wed", 22, 32, 60, "scattered clouds"),
        Weather("Thu", 20, 30, 80, "light rain"),
        Weather("Fri", 18, 25,90, "light rain")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAdapter()
    }

    override fun onStart() {
        super.onStart()

        loadFragment(listFragment)
    }

    private fun setupAdapter() {
        forecast_List.adapter = ForecastListAdapter(this, threeDayForecast)
        forecast_List.layoutManager = LinearLayoutManager(this)
    }

    fun loadFragment(fragment : Fragment): Boolean {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container,fragment)
            .addToBackStack(null)
            .commit()
        return true

    }
}
