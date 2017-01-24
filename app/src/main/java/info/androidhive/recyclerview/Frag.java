package info.androidhive.recyclerview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class Frag extends Fragment {

    private List<Movie> movieList;
    private List<Movie> movieList2;
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private MoviesAdapter mAdapterN;

    RecyclerView.LayoutManager mLayoutManager;

    SharedPreferences settings;

    private static final String PREFS_TAG = "SharedPrefs";
    private static final String PRODUCT_TAG = "MyProduct";
    Gson gson;

    public static final String PREFS_NAME = "MyApp_Settings";
    public static final String PREFS_NAME2 = "MyApp_Setting";
    public static final String ARG_ITEM_ID = "favorite_list";
    private SharedPreferences _privateSharedPrefs;

    private final String SHARED_PREFS_NAME = "app_settings";
    private final String PASSPHRASE_TAG = "user_passphrase";

    private final String EMAIL_TAG = "user_";
    private final String _TAG = "us";

    public Frag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Frag newInstance() {
        Frag fragment = new Frag();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        movieList = new ArrayList<>();
        movieList2 = new ArrayList<>();
        _privateSharedPrefs = getContext().getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        showToastString("resume");

        if (getHashPhrase() != null && getHashPhrase2().equalsIgnoreCase("test2")) {
            Log.d("second ", "subsequent install ");
            movieList2.clear();
            movieList2.addAll(getDataFromSharedPreferences());
            mAdapter = new MoviesAdapter(getContext(), movieList2);
            recyclerView.setAdapter(mAdapter);
            // prepareMovieData();
            mAdapter.notifyDataSetChanged();

            onClickRecylcerview(movieList2);


        } else {
            Log.d("first ", "first install ");
            setHashPhrase("test");
            init();
            onClickRecylcerview(movieList);
        }

    }

    private void init() {

        mAdapter = new MoviesAdapter(movieList);
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
        // restoreLayoutManagerPosition();


    }

    private void onClickRecylcerview(final List<Movie> updateMovieList) {
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = updateMovieList.get(position);
                showToast(position);
                int newPosition = position;

                updateMovieList.remove(newPosition);
                mAdapter.notifyItemRemoved(position);
                mAdapter.notifyItemRangeChanged(newPosition, updateMovieList.size());
                updateMovieList.add(0, new Movie(movie.getTitle(), movie.getGenre(), movie.getYear()));


                setDataFromSharedPreferences(updateMovieList);
                mAdapter.notifyDataSetChanged();
                Log.d("size", "size " + updateMovieList.size());
                for (int i = 0; i < getDataFromSharedPreferences().size(); i++) {
                    //  E element = list.get(i);
                    Log.d("element in list", " " + getDataFromSharedPreferences().get(i).getTitle());
                }


            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }

    @Override
    public void onPause() {
        super.onPause();
        showToastString("onPause");

    }


    @Override
    public void onStop() {
        super.onStop();
        showToastString("stop");
        Log.e("stop", "stop");
        Log.e("first Install", getHashPhrase());

        setHash2("test2");
        if (getHashPhrase3() != null && getHashPhrase3().equalsIgnoreCase("test3")) {
            setDataFromSharedPreferences(movieList2);
            Log.e("second stop", "second stop");
        } else {
            setDataFromSharedPreferences(movieList);
            setHash3("test3");
            Log.e("firststop", "firststop");
        }
    }

    private void showToast(int position) {
        Toast.makeText(getActivity(), "Postion " + position,
                Toast.LENGTH_LONG).show();
    }

    private void showToastString(String string) {
        Toast.makeText(getActivity(), "String " + string,
                Toast.LENGTH_LONG).show();
    }

    public void setHashPhrase(String _hashPhrase) {
        SharedPreferences.Editor editor = _privateSharedPrefs.edit();
        editor.putString(PASSPHRASE_TAG, _hashPhrase);
        editor.commit();
    }

    public String getHashPhrase() {
        return _privateSharedPrefs.getString(PASSPHRASE_TAG, null);
    }

    public void setHash2(String _hashPhras) {
        SharedPreferences.Editor editor = _privateSharedPrefs.edit();
        editor.putString(EMAIL_TAG, _hashPhras);
        editor.commit();
    }

    public String getHashPhrase2() {
        return _privateSharedPrefs.getString(EMAIL_TAG, null);
    }

    public void setHash3(String _hashPhras) {
        SharedPreferences.Editor editor = _privateSharedPrefs.edit();
        editor.putString(_TAG, _hashPhras);
        editor.commit();
    }

    public String getHashPhrase3() {
        return _privateSharedPrefs.getString(_TAG, null);
    }


    private void setDataFromSharedPreferences(List<Movie> curProduct) {
        Gson gson = new Gson();
        String jsonCurProduct = gson.toJson(curProduct);

        SharedPreferences sharedPref = getContext().getSharedPreferences(PREFS_TAG, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putString(PRODUCT_TAG, jsonCurProduct);
        editor.commit();
    }

    private List<Movie> getDataFromSharedPreferences() {
        Gson gson = new Gson();
        List<Movie> productFromShared = new ArrayList<>();
        SharedPreferences sharedPref = getContext().getSharedPreferences(PREFS_TAG, MODE_PRIVATE);
        String jsonPreferences = sharedPref.getString(PRODUCT_TAG, "");

        Type type = new TypeToken<List<Movie>>() {
        }.getType();
        productFromShared = gson.fromJson(jsonPreferences, type);

        // mAdapter.notifyDataSetChanged();
        return productFromShared;
    }

    private void setFirstStop(String firstStop) {
        settings = getContext().getSharedPreferences(PREFS_NAME2, MODE_PRIVATE);

        // Writing data to SharedPreferences
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("stop", firstStop);
        editor.commit();
        // editor.apply();

    }

    private String getFirstInstall() {
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String name = sharedPref.getString("key", "");
        return name;

    }


    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);
        mAdapter.notifyDataSetChanged();
        // return movieList;
        //
    }


}
