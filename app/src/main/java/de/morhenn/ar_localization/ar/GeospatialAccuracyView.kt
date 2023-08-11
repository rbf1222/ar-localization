package de.morhenn.ar_localization.ar

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.ar.core.GeospatialPose
import de.morhenn.ar_localization.R
import de.morhenn.ar_localization.databinding.ViewGeospatialAccuracyBinding

class GeospatialAccuracyView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    //viewBinding
    private var _binding: ViewGeospatialAccuracyBinding? = null
    private val binding get() = _binding!!

    var collapsed = false
        set(value) {
            field = value
            if (value) {
                binding.accuracyLatitude.visibility = GONE
                binding.accuracyLongitude.visibility = GONE
                binding.viewAccLongitudeValue.visibility = GONE
                binding.viewAccLatitudeValue.visibility = GONE
                binding.accuracyInfo.visibility = GONE
                binding.rsrpvalue.visibility = GONE
                binding.rsrqvalue.visibility = GONE
                binding.sinrvalue.visibility = GONE
                binding.accuracyCollapsedView.visibility = VISIBLE
            } else {
                binding.viewAccLongitudeValue.visibility = VISIBLE
                binding.viewAccLatitudeValue.visibility = VISIBLE
                binding.accuracyLatitude.visibility = VISIBLE
                binding.accuracyLongitude.visibility = VISIBLE
                binding.accuracyInfo.visibility = VISIBLE
                binding.rsrpvalue.visibility = VISIBLE
                binding.rsrqvalue.visibility = VISIBLE
                binding.sinrvalue.visibility = VISIBLE
                binding.accuracyCollapsedView.visibility = GONE
            }
        }

    init {
        _binding = ViewGeospatialAccuracyBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
        binding.viewGeospatialAccuracy.setOnClickListener {
            collapsed = collapsed
        }
    }

    fun updateView(latitude : Double,longitude : Double, rsrp : Int, rsrq : Int, level : Int , sinr : Int) {
        binding.viewAccLatitudeValue.visibility = VISIBLE
        binding.viewAccLongitudeValue.visibility = VISIBLE
        binding.rsrpvalue.visibility = VISIBLE
        binding.rsrqvalue.visibility = VISIBLE
        binding.latitude.visibility = VISIBLE
        binding.longitude.visibility = VISIBLE
        binding.rsrptext.visibility = VISIBLE
        binding.rsrqtext.visibility = VISIBLE
        binding.sinrtext.visibility = VISIBLE

        var colorf = Color.BLACK
        //UI elements for camerapose Latitude
        binding.viewAccLatitudeValue.text = String.format("%.7f",latitude)
        //UI elements for camerapose Longitude
        binding.viewAccLongitudeValue.text = String.format("%.7f",longitude)

        when(level){
            0 -> {colorf = ContextCompat.getColor(context,R.color.none)}
            1 -> {colorf = ContextCompat.getColor(context,R.color.poor)}
            2 -> {colorf = ContextCompat.getColor(context,R.color.moderate)}
            3 -> {colorf = ContextCompat.getColor(context,R.color.good)}
            4 -> {colorf = ContextCompat.getColor(context,R.color.great)}
        }

        binding.rsrpvalue.text = rsrp.toString()
        binding.rsrpvalue.setTextColor(colorf)
        binding.rsrqvalue.text = rsrq.toString()
        binding.rsrqvalue.setTextColor(colorf)
        binding.sinrvalue.text = sinr.toString()
        binding.sinrvalue.setTextColor(colorf)
    }
}
