package de.morhenn.ar_localization.ar

/*
 원작자(author) : morhenny
 작성자(writer) : rbf1222
 날짜(data) : 2023.08.29
 수정사항(modification) : 전체(all)
 세부사항(detail) : 원본 GeospatialAccuracyView 클래스는 이름에서도 알 수 있듯 Geospatial의 정확도를
                매핑(Mapping)이나 측위(Localizaing)할때 상단에 표시하기 위함이다.
                허나 Geospatial의 정확도는 Toast로 출력하여도 충분하다고 판단되었으며,
                해당 View를 목적에 맞게 셀 정보(RSRQ,RSRP,SINR) 및 위도,경도를 출력하는데 사용하면 좋을 것으로 생각되어 이에 맞게 변경되었다.
                또한 GeospatialAccuracyView의 레이아웃인 view_geospatial_accuracy.xml을 목적에 맞게 수정되었다.
                updateView()의 매개변수는 셀 정보를 표시하고자 변경되었다.
 */

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
            if (value) { // View : OFF
                binding.accuracyLatitude.visibility = GONE
                binding.accuracyLongitude.visibility = GONE
                binding.viewAccLongitudeValue.visibility = GONE
                binding.viewAccLatitudeValue.visibility = GONE
                binding.accuracyInfo.visibility = GONE
                binding.rsrpvalue.visibility = GONE
                binding.rsrqvalue.visibility = GONE
                binding.sinrvalue.visibility = GONE
                binding.accuracyCollapsedView.visibility = VISIBLE
            } else { // View : ON
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

    fun updateView(latitude : Double,longitude : Double, rsrp : Int, rsrq : Int, level : Int , sinr : Int) { // 셀 정보도 Input값으로 받는다.
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

        // RSRQ,RSRP,SINR의 색상은 수신상태(Level 5단계 : 0~4)에 준하여 계산된다.
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
