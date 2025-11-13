package tdung.baitap01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import tdung.baitap01.databinding.FragmentBaiTap4Binding
import java.lang.NumberFormatException

class BaiTap4Fragment : Fragment() {
    private var _binding: FragmentBaiTap4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBaiTap4Binding.inflate(inflater, container, false)

        binding.btnSplit.setOnClickListener {
            val input = binding.edtNumbers.text.toString().trim()
            if (input.isEmpty()) {
                Toast.makeText(requireContext(), "Nhập dãy số đã", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Chia theo space/comma/semicolon
            val tokens = input.split(Regex("[,;\\s]+")).filter { it.isNotEmpty() }
            val evens = mutableListOf<Int>()
            val odds = mutableListOf<Int>()
            val badTokens = mutableListOf<String>()

            for (t in tokens) {
                try {
                    val n = t.toInt()
                    if (n % 2 == 0) evens.add(n) else odds.add(n)
                } catch (ex: NumberFormatException) {
                    badTokens.add(t)
                }
            }

            val evenText = if (evens.isEmpty()) "Chẵn: (không có)" else "Chẵn: ${evens.joinToString(", ")}"
            val oddText = if (odds.isEmpty()) "Lẻ: (không có)" else "Lẻ: ${odds.joinToString(", ")}"

            binding.tvEven.text = evenText
            binding.tvOdd.text = oddText

            if (badTokens.isNotEmpty()) {
                Toast.makeText(requireContext(), "Bỏ qua token không phải số: ${badTokens.joinToString(", ")}", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
