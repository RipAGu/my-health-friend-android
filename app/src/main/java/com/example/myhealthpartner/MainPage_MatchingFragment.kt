package com.example.myhealthpartner

import android.app.AlertDialog
import android.media.Image
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import org.w3c.dom.Text

class MainPage_MatchingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_page_matching_fragment, container, false)
        val checkboxLinear = view.findViewById<LinearLayout>(R.id.checkboxLinear)
        val timeCheckbox = view.findViewById<LinearLayout>(R.id.timeCheckbox)
        timeCheckbox.visibility = View.GONE
        checkboxLinear.visibility = View.GONE
        initEvent(view)
        return view
    }


    fun initEvent(myView: View) {
        val loginData = context?.getSharedPreferences("loginData", 0)
        val checkboxLinear = myView.findViewById<LinearLayout>(R.id.checkboxLinear)
        val timeCheckbox = myView.findViewById<LinearLayout>(R.id.timeCheckbox)
        val timeCheckBtn = myView.findViewById<ImageButton>(R.id.timeCheckBtn)
        val fitnessListBtn = myView.findViewById<ImageButton>(R.id.fitnessListBtn)
        val baseAddressBtn = myView.findViewById<Button>(R.id.baseAddressBtn)

        baseAddressBtn.setOnClickListener {
            val addressTextView = myView.findViewById<TextView>(R.id.addressTextView)
            addressTextView.text = loginData!!.getString("address", "")
        }

        fitnessListBtn.setOnClickListener {
            if(checkboxLinear.visibility == View.GONE){
                checkboxLinear.visibility = View.VISIBLE
            }
            else{
                checkboxLinear.visibility = View.GONE
            }
        }
        timeCheckBtn.setOnClickListener {
            if(timeCheckbox.visibility == View.GONE) timeCheckbox.visibility = View.VISIBLE
            else timeCheckbox.visibility = View.GONE
        }

    }



}


