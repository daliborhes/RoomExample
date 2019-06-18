package com.daliborhes.roomsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Dalibor J. Stanković on 18.06.2019.
 */

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private Context context;
    private List<Word> wordList;

    public WordListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if (wordList != null) {
            Word currentWord = wordList.get(position);
            holder.textView.setText(currentWord.getWord());
        } else {
            holder.textView.setText("No word");
        }
    }

    void setWords(List<Word> words){
        wordList = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (wordList != null) {
            return wordList.size();
        } else {
            return 0;
        }

    }


    public class WordViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
        }
    }
}
