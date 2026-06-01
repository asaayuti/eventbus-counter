package com.sayuti.eventbus

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sayuti.eventbus.databinding.FragmentControlBinding
import org.greenrobot.eventbus.EventBus

class ControlFragment : Fragment(R.layout.fragment_control) {

    // ga ada listener sama sekali
    private var counter = 0

    private var _binding: FragmentControlBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentControlBinding.bind(view)

        binding.btnIncrement.setOnClickListener {
            counter++
            EventBus.getDefault().post(CounterEvent(counter))
        }

        binding.btnDecrement.setOnClickListener {
            counter--
            EventBus.getDefault().post(CounterEvent(counter))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}