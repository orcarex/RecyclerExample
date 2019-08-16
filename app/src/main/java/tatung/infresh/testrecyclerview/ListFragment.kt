package tatung.infresh.testrecyclerview


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    var threeDayForecast = mutableListOf<Weather>(
        Weather("Wed", 22, 32, 60, "scattered clouds"),
        Weather("Thu", 20, 30, 80, "light rain"),
        Weather("Fri", 18, 25,90, "light rain")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
    }

    private fun setupAdapter() {
        frag_list.adapter = ForecastListAdapter(context!! , threeDayForecast)
        frag_list.layoutManager = LinearLayoutManager(context)
    }

}