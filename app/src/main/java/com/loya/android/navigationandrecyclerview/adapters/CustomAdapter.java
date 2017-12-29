package com.loya.android.navigationandrecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loya.android.navigationandrecyclerview.R;
import com.loya.android.navigationandrecyclerview.models.Word;

import java.util.ArrayList;

/**
 * Created by Ikhiloya on 12/29/2017.
 * A Custom Adapter class that handles how the recycler view is displayed
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Word> words;

    private ListItemClickListener listItemClickListener;

    /**
     * an interface to handle click events on a card
     */
    public interface ListItemClickListener {
        void onListItemClick(String alphabet, String word);
    }

    public CustomAdapter(Context context, ArrayList<Word> words, ListItemClickListener listItemClickListener) {
        this.context = context;
        this.words = words;
        this.listItemClickListener = listItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Word word = words.get(position);
        holder.alphabetTextView.setText(word.getAlphabet());
        holder.wordTextView.setText(word.getWord());

    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView alphabetTextView;
        private TextView wordTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            alphabetTextView = itemView.findViewById(R.id.alphabet_text);
            wordTextView = itemView.findViewById(R.id.word_text);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Word word = words.get(getAdapterPosition());
            String alphabetText = word.getAlphabet();
            String wordText = word.getWord();
            listItemClickListener.onListItemClick(alphabetText, wordText);
        }
    }
}
