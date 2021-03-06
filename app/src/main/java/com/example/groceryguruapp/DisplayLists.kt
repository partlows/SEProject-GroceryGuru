package com.example.groceryguruapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.groceryguruapp.db.DbHelper
import com.example.groceryguruapp.db.DbModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DisplayLists.newInstance] factory method to
 * create an instance of this fragment.
 */
class DisplayLists : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_lists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbHelper = DbHelper(context!!);
        view.findViewById<Button>(R.id.show_grocery_lists).setOnClickListener {
            var lists = dbHelper.showAllGroceryLists()

            var groceryLists = ArrayList<String>(lists.size)

            for(i in lists) {
                for(j in i.list) {
                    groceryLists.add("ID: " + i.listid + "\nItemId: " + j);
                }
            }

            val adapter = ArrayAdapter(context!!, android.R.layout.simple_list_item_1, lists)
            view.findViewById<ListView>(R.id.list_view_display_grocery_lists).adapter = adapter
        }

        view.findViewById<Button>(R.id.display_grocery_lists_to_dev_page_btn).setOnClickListener {
            findNavController().navigate(R.id.action_displayLists_to_developerHomePage);
        }

        view.findViewById<Button>(R.id.delete_all_grocery_lists_btn).setOnClickListener {
            // dbHelper.deleteAllUsers()
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DisplayLists.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DisplayLists().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
