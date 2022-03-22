package com.example.learningandroid.ui.orderedlist

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.learningandroid.R
import com.example.learningandroid.fragments.EmployeeFragment
import com.example.learningandroid.fragments.StartFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_check_employee.*

class CheckEmployeeId(context: Context): DialogFragment(R.layout.dialog_check_employee) { //AppCompatDialog(context) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val btnCancel = view.findViewById<Button>(R.id.btnCancel)
        val etLoginInput = view.findViewById<EditText>(R.id.etLoginInput)
        val employeeIdList = listOf<Int>(1, 2, 3)
        val employeeFragment = EmployeeFragment()

        btnLogin?.setOnClickListener {
            if (etLoginInput?.text != null && etLoginInput?.text.toString().isEmpty()) {
                Toast.makeText(context, "Please enter your Employee Id", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val employeeId = etLoginInput?.text.toString().toInt()
            if (employeeIdList.contains(employeeId)) {
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, employeeFragment)
                    commit()
                    dismiss()
                }
            }else{
                Toast.makeText(context, "Not a valid Employee Id", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

        btnCancel?.setOnClickListener {
            dismiss()
        }

    }
}