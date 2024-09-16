package com.example.pypl2.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pypl2.LangsAdapter
import com.example.pypl2.WordListAdapter
import com.example.pypl2.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var dashboardViewModel:DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onStart() {
        super.onStart()
        dashboardViewModel.getMarsPhotos()

        var adapter = WordListAdapter()
        binding.recyclerView2.layoutManager =  LinearLayoutManager(context)
        binding.recyclerView2.adapter = adapter


        dashboardViewModel.allWords.observe(viewLifecycleOwner) { listMarsPhotos ->
            // Update the cached copy of the words in the adapter.
            listMarsPhotos.let { adapter.submitList(it) }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}