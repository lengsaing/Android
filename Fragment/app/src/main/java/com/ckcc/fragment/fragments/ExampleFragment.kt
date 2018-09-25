package com.ckcc.fragment.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.ckcc.fragment.R
import kotlinx.android.synthetic.main.fragment_example.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_NAME = "name"
private const val ARG_AGE = "age"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ExampleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ExampleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ExampleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var name: String? = null
    private var age: Int? = 0
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //attach the const to the variables for usage
            name = it.getString(ARG_NAME)
            age = it.getInt(ARG_AGE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_example, container, false)
        btnfragment.setOnClickListener {
            listener?.onButtonClick()
        }
        Toast.makeText(context, "$name is $age", Toast.LENGTH_SHORT).show()
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onButtonClick()
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(name: String, age: Int) =
                ExampleFragment().apply {
                    arguments = Bundle().apply {

                        //put sent arguments inside the constants
                        putString(ARG_NAME, name)
                        putInt(ARG_AGE, age)
                    }
                }
    }
}
