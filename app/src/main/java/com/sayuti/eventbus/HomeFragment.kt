package com.sayuti.eventbus

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sayuti.eventbus.databinding.FragmentHomeBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // register/unregister EventBus
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    // handle event sendiri, ga perlu dipanggil dari luar
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onCounterEvent(event: CounterEvent) {
        binding.tvCounter.text = event.value.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}