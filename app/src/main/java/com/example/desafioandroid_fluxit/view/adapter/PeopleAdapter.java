package com.example.desafioandroid_fluxit.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.desafioandroid_fluxit.R;
import com.example.desafioandroid_fluxit.model.Person;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PeopleAdapter extends RecyclerView.Adapter {

    private List<Person> personList;
    private PeopleAdapterListener peopleAdapterListener;

    public PeopleAdapter(List<Person> personList, PeopleAdapterListener peopleAdapterListener) {
        this.personList = personList;
        this.peopleAdapterListener = peopleAdapterListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.person_item, parent, false);
        PersonViewHolder personViewHolder = new PersonViewHolder(view);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Person person = personList.get(position);
        PersonViewHolder personViewHolder = (PersonViewHolder) holder;
        personViewHolder.bind(person);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imageViewPersonItem)
        ImageView imageViewPersonItem;
        @BindView(R.id.textViewNickPersonItem)
        TextView textViewNickPersonItem;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Person person = personList.get(getAdapterPosition());
                    peopleAdapterListener.choice(person);
                }
            });

        }
        public void bind(Person person){
            Glide.with(itemView).load(person.getPicture().getThumbnail()).into(imageViewPersonItem);
            textViewNickPersonItem.setText(person.getLogin().getUsername());

        }
    }

    public interface PeopleAdapterListener {
         void choice(Person person);
    }
}
