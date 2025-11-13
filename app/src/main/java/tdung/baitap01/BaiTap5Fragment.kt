package tdung.baitap01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import tdung.baitap01.databinding.FragmentBaiTap5Binding

class BaiTap5Fragment : Fragment() {

    private var _binding: FragmentBaiTap5Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBaiTap5Binding.inflate(inflater, container, false)

        binding.btnReverse.setOnClickListener {
            val input = binding.edtString.text.toString().trim()
            if (input.isEmpty()) {
                Toast.makeText(requireContext(), "Nhập chuỗi ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val reversed = input.reversed().uppercase()
            binding.tvResult.text = reversed
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
