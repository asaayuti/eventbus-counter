package com.sayuti.eventbus

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sayuti.eventbus.databinding.FragmentControlBinding

class ControlFragment : Fragment(R.layout.fragment_control) {

    var listener: CounterListener? = null // di-set dari MainActivity
    private var counter = 0

    private var _binding: FragmentControlBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentControlBinding.bind(view)

        binding.btnIncrement.setOnClickListener {
            counter++
            listener?.onCounterChanged(counter)
        }

        binding.btnDecrement.setOnClickListener {
            counter--
            listener?.onCounterChanged(counter)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}