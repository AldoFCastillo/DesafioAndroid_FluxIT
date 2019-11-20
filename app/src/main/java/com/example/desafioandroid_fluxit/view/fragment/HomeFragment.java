package com.example.desafioandroid_fluxit.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.desafioandroid_fluxit.R;
import com.example.desafioandroid_fluxit.controller.PeopleController;
import com.example.desafioandroid_fluxit.dao.PeopleDAO;
import com.example.desafioandroid_fluxit.model.Person;
import com.example.desafioandroid_fluxit.model.Results;
import com.example.desafioandroid_fluxit.utils.ResultListener;
import com.example.desafioandroid_fluxit.view.activity.DetailsActivity;
import com.example.desafioandroid_fluxit.view.adapter.PeopleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements PeopleAdapter.PeopleAdapterListener, PeopleDAO.showError {

    @BindView(R.id.recyclerViewHomeFragment)
    RecyclerView recyclerViewHomeFragment;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.listView)
    ListView listView;

    private notifier aNotifier;

    private List<Person> personList = new ArrayList<>();

    private ArrayAdapter<String> arrayAdapter;
    private Map<String, Person> nickMap = new HashMap<>();
    private List<String> nickList = new ArrayList<>();
    private  List<String> arrayItems = new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.aNotifier = (notifier) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        showProgressView();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerViewHomeFragment.setLayoutManager(layoutManager);

        PeopleController peopleController = new PeopleController();
        callAPI(peopleController);
        refresh(peopleController);


        arrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1, nickList);
        listView.setAdapter(arrayAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                listView.setVisibility(View.VISIBLE);
                if (newText.equals(""))listView.setVisibility(View.GONE);
                return false;
            }
        });



        return view;
    }

    public void callAPI(PeopleController peopleController) {
        peopleController.getPeopleList(new ResultListener<Results>() {
            @Override
            public void onFinish(Results result) {
                personList = result.getResults();
                hideProgressView();
                PeopleAdapter peopleAdapter = new PeopleAdapter(personList, HomeFragment.this);
                recyclerViewHomeFragment.setAdapter(peopleAdapter);
                swipeRefreshLayout.setRefreshing(false);
                recyclerViewHomeFragment.setHasFixedSize(true);
                recyclerViewHomeFragment.setItemViewCacheSize(20);
                for (Person person: personList) {
                    String nick = person.getLogin().getUsername();
                    nickMap.put(nick, person);
                    nickList.add(nick);
                }
                itemClick();

            }
        });
    }

    private void itemClick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String listItem = (String) parent.getAdapter().getItem(position);
                Person aPerson = nickMap.get(listItem);
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                bundle.putSerializable(DetailsActivity.KEY_PERSON, aPerson);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void refresh(PeopleController peopleController) {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            personList.clear();
            callAPI(peopleController);
        });
    }

    void showProgressView() {
        progressBar.setVisibility(View.VISIBLE);
    }

    void hideProgressView() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void choice(Person person) {
        aNotifier.sendNotification(person);
    }

    @Override
    public void error(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    public interface notifier {
        public void sendNotification(Person person);
    }

}
