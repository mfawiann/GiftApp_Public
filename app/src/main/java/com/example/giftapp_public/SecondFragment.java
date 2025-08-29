package com.example.giftapp_public;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.giftapp_public.databinding.FragmentSecondBinding;

/**
 * SecondFragment:
 * - Example fragment using ViewBinding.
 * - Contains a button that navigates back to FirstFragment.
 *
 * Public-friendly notes:
 * 1. Uses FragmentSecondBinding (auto-generated from fragment_second.xml).
 * 2. Navigation requires action defined in nav_graph.xml:
 *    R.id.action_SecondFragment_to_FirstFragment
 * 3. Safe cleanup of binding in onDestroyView to avoid memory leaks.
 */
public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout using ViewBinding
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Button click navigates back to FirstFragment
        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Avoid memory leaks
        binding = null;
    }
}
