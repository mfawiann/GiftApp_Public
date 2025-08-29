package com.example.giftapp_public;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * BirthdayTextFragment
 *
 * Displays a sample letter. Replace the placeholder text with your own content if needed.
 */
public class BirthdayTextFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_birthday_text, container, false);

        TextView textLetter = view.findViewById(R.id.textLetter);

        // Placeholder letter text
        String letter = "This is a sample letter.\n\n"
                + "You can replace this text with any personal message "
                + "that you want to display in this section of the app.\n\n"
                + "For example: a birthday greeting, a thank you note, or a motivational quote.";

        textLetter.setText(letter);

        return view;
    }
}
