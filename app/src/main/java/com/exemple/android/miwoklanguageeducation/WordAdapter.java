package com.exemple.android.miwoklanguageeducation;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> wordsList, int colorResourceId) {
        super(context, 0, wordsList);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);
        assert currentWord != null;
        TextView defaultTranslation = listItemView.findViewById(R.id.englishWord);

        defaultTranslation.setText(currentWord.getDefaultTranslation());

        TextView miwokTranslation = listItemView.findViewById(R.id.miwokWord);
        miwokTranslation.setText(currentWord.getMiwokTranslation());

        ImageView picturesId = listItemView.findViewById(R.id.picture);
        if (currentWord.getHasImage()) {
            picturesId.setImageResource(currentWord.getPicturesId());
            picturesId.setVisibility(View.VISIBLE);
        } else {
            picturesId.setVisibility(View.GONE);
        }

        View containerView = listItemView.findViewById(R.id.elementsText);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        containerView.setBackgroundColor(color);

        return listItemView;
    }
}
