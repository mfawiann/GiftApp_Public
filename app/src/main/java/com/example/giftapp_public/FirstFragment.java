package com.example.giftapp_public;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.giftapp_public.databinding.FragmentFirstBinding;

/**
 * FirstFragment:
 * - Example fragment using ViewBinding.
 * - Contains a button that navigates to SecondFragment.
 *
 * Public-friendly notes:
 * 1. Uses FragmentFirstBinding (auto-generated from fragment_first.xml).
 * 2. Navigation requires action defined in nav_graph.xml:
 *    R.id.action_FirstFragment_to_SecondFragment
 * 3. Safe cleanup of binding in onDestroyView to avoid memory leaks.
 */
public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout using ViewBinding
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Button click navigates to SecondFragment
        binding.buttonFirst.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Avoid memory leaks
        binding = null;
    }
}
