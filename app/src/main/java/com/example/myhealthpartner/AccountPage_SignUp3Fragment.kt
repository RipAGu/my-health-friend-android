package com.example.myhealthpartner

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class AccountPage_SignUp3Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.account_page_sign_up3_fragment, container, false)
        initEvent(view)
        return view
    }

    fun initEvent(myView : View){
        val changeFragment = context as ChangeFragment
        val signupBtn = myView.findViewById<Button>(R.id.signUpBtn)
        val certificationLayout = myView.findViewById<LinearLayout>(R.id.certificationLayout)
        certificationLayout.visibility = View.GONE

        signupBtn.setOnClickListener {
            val dialogTemp2 = AlertDialog.Builder(context)
            val dialog2 = dialogTemp2.create()
            val dialogViewTemp = layoutInflater.inflate(R.layout.common_alert_dialog,null)
            val alertMessage = dialogViewTemp.findViewById<TextView>(R.id.alertMessage)
            alertMessage.text = "회원가입 성공!"
            dialog2.setView(dialogViewTemp)
            dialog2.show()
            dialogViewTemp.findViewById<Button>(R.id.confirmButton).setOnClickListener{
                dialog2.dismiss()
            }
            changeFragment.change(0)
        }
        myView.findViewById<Button>(R.id.getCertificationBtn).setOnClickListener{
            if(certificationLayout.visibility == View.GONE){
                certificationLayout.visibility = View.VISIBLE
            }
            else{
                certificationLayout.visibility = View.GONE
            }
        }
    }
}