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
import androidx.cardview.widget.CardView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.braintreepayments.cardform.view.CardForm
import com.example.learningandroid.R
import com.example.learningandroid.data.db.entity.OrderedItems
import com.example.learningandroid.fragments.EmployeeFragment
import com.example.learningandroid.fragments.StartFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_check_employee.*

class PaymentDialog(list: List<String>, ViewModel: OrderedViewModel, TableNumber: Int): DialogFragment(R.layout.dialog_payment) { //AppCompatDialog(context) {

    private val items: List<String> = list
    private val viewModel = ViewModel
    private val tableNumber = TableNumber

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnPayNow = view.findViewById<Button>(R.id.btnPayNow)
        val btnCancel = view.findViewById<Button>(R.id.btnCancel)
        val cfPayNow = view.findViewById<CardForm>(R.id.cfPayNow)
        val startFragment = StartFragment()

        cfPayNow.cardRequired(true)
        cfPayNow.expirationRequired(true)
        cfPayNow.cardholderName(CardForm.FIELD_REQUIRED)
        cfPayNow.cvvRequired(true)
        cfPayNow.setup(activity as MainActivity)

        btnPayNow?.setOnClickListener {
            cfPayNow.validate()
            if(cfPayNow.isValid()){
                dismiss()
                for (item in items) {
                    val orderedItem = OrderedItems(tableNumber, item)
                    viewModel.upsert(orderedItem)
                }
                (activity as MainActivity).clearList()
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, startFragment)
                    commit()
                    Toast.makeText(activity as MainActivity, "Thank you! Your order will be out shortly", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnCancel?.setOnClickListener {
            dismiss()
        }

    }
}