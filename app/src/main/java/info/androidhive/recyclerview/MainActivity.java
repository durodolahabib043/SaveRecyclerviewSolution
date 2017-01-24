package info.androidhive.recyclerview;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends FragmentActivity {
    //// try inside  fragment
    private Fragment contentFragment;

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    SharedPreferences prefs;
    String key = "key";
    String arraykey = "arraykey";
    Parcelable listState;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    RecyclerView.LayoutManager mLayoutManager;

    private static Bundle mBundleRecyclerViewState;
    Parcelable state;


    SharedPreferences preferences;
    SharedPreference sharedPreference;
    SharedPreferences.Editor editor;
    int lastFirstVisiblePosition;

    Gson gson;
    boolean validate;

    private static final String PREFS_TAG = "SharedPrefs";
    private static final String PRODUCT_TAG = "MyProduct";

    List<Movie> _mov = new ArrayList<Movie>();
    List<Movie> _mov2 = new ArrayList<Movie>();
    Set<Movie> set = new HashSet<Movie>();
    Set<Movie> set2 = new HashSet<Movie>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FragmentManager fragmentManager = getSupportFragmentManager();
       // setSupportActionBar(toolbar);

       // switchContent();

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("content")) {
                String content = savedInstanceState.getString("content");
                if (content.equals(Frag.ARG_ITEM_ID)) {
                    if (fragmentManager.findFragmentByTag(Frag.ARG_ITEM_ID) != null) {
                       // setFragmentTitle(R.string.favorites);
                        contentFragment = fragmentManager
                                .findFragmentByTag(Frag.ARG_ITEM_ID);
                    }
                }
            }
            /*if (fragmentManager.findFragmentByTag(ProductListFragment.ARG_ITEM_ID) != null) {
                pdtListFragment = (ProductListFragment) fragmentManager
                        .findFragmentByTag(ProductListFragment.ARG_ITEM_ID);
                contentFragment = pdtListFragment;
            }*/
        } else {
           switchContent();
        }


    }


    public void switchContent() {


        Frag frag = Frag.newInstance();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.contentlayout, frag);
        transaction.commit();


    }

     /*   sharedPreference = new SharedPreference();

        //  mBundleRecyclerViewState = new Bundle();


        _mov = new ArrayList<Movie>();
        _mov2 = new ArrayList<Movie>();
        set = new HashSet<Movie>();
        set2 = new HashSet<Movie>();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();


        gson = new Gson();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);
     *//*   Set<String> tasksSet = PreferenceManager.getDefaultSharedPreferences(context)
                .getStringSet("tasks_set", new HashSet<String>());
        List<String> tasksList = new ArrayList<String>(tasksSet);*//*


        // Set<String> set  =  preferences.getStringSet(key , null) ;

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.setAdapter(mAdapter);
        //...
        // Restore previous state (including selected item index and scroll position)
        if (state != null) {
            //   Log.d(TAG, "trying to restore listview state..");
            recyclerView.getLayoutManager().onRestoreInstanceState(state);
        }*/
    //  recyclerView.setAdapter(mAdapter);

/*
        if (savedInstanceState != null) {
            //  Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(KEY_RECYCLER_STATE);
            //   recyclerView.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
            *//*Toast.makeText(this, "restore",
                    Toast.LENGTH_LONG).show();

            ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPosition(lastFirstVisiblePosition);*//*
        } else {
            recyclerView.setAdapter(mAdapter);
        }*/

     /*   if (mBundleRecyclerViewState != null) {
            Parcelable listState = mBundleRecyclerViewState.getParcelable(KEY_RECYCLER_STATE);
            recyclerView.getLayoutManager().onRestoreInstanceState(listState);
        } else {
            recyclerView.setAdapter(mAdapter);
        }
*/
/*

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("content")) {
                String content = savedInstanceState.getString("content");
                if (content.equals("saveActivity")) {
                    Toast.makeText(this, "savedInstanceState",
                            Toast.LENGTH_LONG).show();
                    recyclerView.setAdapter(new MoviesAdapter(getDataFromSharedPreferences()));

                  */
/*  if (fragmentManager.findFragmentByTag(FavoriteListFragment.ARG_ITEM_ID) != null) {
                        setFragmentTitle(R.string.favorites);
                        contentFragment = fragmentManager
                                .findFragmentByTag(FavoriteListFragment.ARG_ITEM_ID);
                    }*//*

                }
            }

        } else {
            recyclerView.setAdapter(mAdapter);
        }
*/


     /*   /// logic to save  in sharepref
        if (getDataFromSharedPreferences() != null ) {
            *//*if (getCNN().equalsIgnoreCase("saved")) {
                Log.i(" save arraylist ", " " + getDataFromSharedPreferences());
                //recyclerView.setAdapter(new MoviesAdapter(getDataFromSharedPreferences()));
            }*//*
            Log.i(" save arraylist ", " " + getDataFromSharedPreferences());
            recyclerView.setAdapter(new MoviesAdapter(getDataFromSharedPreferences()));

        } else {
            recyclerView.setAdapter(mAdapter);

        }
*/
/*
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);


                // movieList.remove(position);

*//*
                if (getCNN() != null && getDataFromSharedPreferences().size() != 0) {
                    Log.i("size " , "" +  getDataFromSharedPreferences().size()) ;
                    getDataFromSharedPreferences().remove(position);
                    new MoviesAdapter(getDataFromSharedPreferences()).notifyItemRemoved(position);
                    //  mAdapter.notifyItemRemoved(position);
                    new MoviesAdapter(getDataFromSharedPreferences()).notifyItemRangeChanged(position, getDataFromSharedPreferences().size());
                    getDataFromSharedPreferences().add(0, new Movie(movie.getTitle(), movie.getGenre(), movie.getYear()));
                    new MoviesAdapter(getDataFromSharedPreferences()).notifyDataSetChanged();
                    set2.clear();
                    set2.addAll(getDataFromSharedPreferences());
                    _mov2.clear();
                    _mov2.addAll(set2);
                    setDataFromSharedPreferences(_mov2);

                }*//*


                //   Log.i("Movie", " " + movie.getYear());
               *//* mAdapter.notifyItemRemoved(position);
                mAdapter.notifyItemRangeChanged(position, movieList.size());*//*


                ////// working
                // movieList.clear();
                movieList.remove(position);
                mAdapter.notifyItemRemoved(position);
                mAdapter.notifyItemRangeChanged(position, movieList.size());
                movieList.add(0, new Movie(movie.getTitle(), movie.getGenre(), movie.getYear()));
                mAdapter.notifyDataSetChanged();
                set.clear();
                set.addAll(movieList);
                _mov.clear();
                _mov.addAll(set);
                setDataFromSharedPreferences(_mov);

                for (int i = 0; i < getDataFromSharedPreferences().size(); i++) {
                    System.out.println("=============================================");
                    System.out.println("get saved data " + getDataFromSharedPreferences().get(i).getTitle() + " " + " " + i);
                    System.out.println("=============================================");

                    //     Log.i(" get saved data " , getDataFromSharedPreferences().get(i).getTitle());


                }


                ////// working
                //  setDataFromSharedPreferences(_mov);


                // setCNN("saved");


                //   setDataFromSharedPreferences(movie) ;
                // saveArrayList(movieList);

                //  List<Movie> _mov = new ArrayList<Movie>();


// save  to share pref



              *//*  Gson gson = new Gson();
                String json = gson.toJson(movieList);
                editor.putString(key, json);
                editor.commit();*//*

// set save

                // validate = true;


            }

            @Override
            public void onLongClick(View view, int position) {
                Movie movie = movieList.get(position);
                sharedPreference.addFavorite(getApplicationContext(), new Movie(movie.getTitle(), movie.getGenre(), movie.getYear()));

                Toast.makeText(getApplicationContext(), " " + movie,
                        Toast.LENGTH_LONG).show();

            }
        }));

        prepareMovieData();
    }


    public void setLatestArrayList(List<Movie> favorites) {
        //favorites.clear();

        // SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString("key", jsonFavorites);
        //   Log.e("TAG saved", jsonFavorites);

        editor.commit();
    }


    public String getLatestArrayList() {
        SharedPreferences settings;
        List<Movie> favorites;


        //_privateSharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);


        String jsonFavorites = preferences.getString("key", null);
        *//*Gson gson = new Gson();
        Movie[] favoriteItems = gson.fromJson(jsonFavorites,
                Movie[].class);




       favorites = Arrays.asList(favoriteItems);
        favorites = new ArrayList<Movie>(favorites);*//*
        //   Log.e("TAG fav", jsonFavorites);

        return jsonFavorites;
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
    }*/

/*
    private void saveArrayList(List list) {
    */
/*    Set<String> set = new HashSet<String>();
        set.addAll(list);
        scoreEditor.putStringSet("key", set);
        scoreEditor.commit();*//*


    }

    */
/*   @Override
       public void onViewCreated(final View view, Bundle savedInstanceState) {
           super.onViewCreated(view, savedInstanceState);
           // Set new items
           listView.setAdapter(adapter);
           ...
           // Restore previous state (including selected item index and scroll position)
           if(state != null) {
               Log.d(TAG, "trying to restore listview state..");
               listView.onRestoreInstanceState(state);
           }
       }
   *//*

    private List<Movie> getDataFromSharedPreferences() {
        List<Movie> productFromShared = new ArrayList<>();
        productFromShared.clear();

        String jsonPreferences = preferences.getString(PRODUCT_TAG, "");

        Type type = new TypeToken<List<Movie>>() {
        }.getType();
        //   productFromShared = gson.fromJson(jsonPreferences, type);


        productFromShared = gson.fromJson(jsonPreferences, type);

        // Log.e("TAG prefromshared", " " + productFromShared);

        return productFromShared;
    }

    private void setDataFromSharedPreferences(List<Movie> favorites) {

        final Gson gson = new GsonBuilder().create();
        String jsonCurProduct = gson.toJson(favorites);

     */
/*   SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(PREFS_TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();*//*

        editor.clear();
        editor.putString(PRODUCT_TAG, jsonCurProduct);
        editor.commit();

        //  Log.e("TAG", jsonCurProduct);
    }


    public void setCNN(String cnn) {
        SharedPreferences.Editor editor = preferences.edit();
        // editor.clear();
        editor.putString("key", cnn);
        editor.commit();
    }

    public String getCNN() {
        return preferences.getString("key", null);
    }
*/

/*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //  if (contentFragment instanceof FavoriteListFragment) {
        //  outState.putString("content", "saveActivity");

        // outState = new Bundle();
        //   Parcelable listState = recyclerView.getLayoutManager().onSaveInstanceState();
        //outState.putParcelable(KEY_RECYCLER_STATE, listState);
        outState.putParcelable(KEY_RECYCLER_STATE, recyclerView.getLayoutManager().onSaveInstanceState());
        Toast.makeText(this, "savedInstanceState",
                Toast.LENGTH_LONG).show();
        super.onSaveInstanceState(outState);



        */
/*
        *
        *  Bundle bundle = new Bundle();
        bundle.putParcelable(SAVED_SUPER_STATE, super.onSaveInstanceState());
        bundle.putParcelable(SAVED_LAYOUT_MANAGER, this.getLayoutManager().onSaveInstanceState());
        return bundle;*//*




        */
/*
        *
        *
        *
        *  Bundle bundle = new Bundle();
   bundle.putParcelable(SAVED_LAYOUT_MANAGER, recyclerView.getLayoutManager().onSaveInstanceState());
   return bundle;*//*

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {


        // Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(KEY_RECYCLER_STATE);
      */
/*  if (savedInstanceState != null) {
            Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(KEY_RECYCLER_STATE);
            recyclerView.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
            Toast.makeText(this, "restore",
                    Toast.LENGTH_LONG).show();
        }*//*



        */
/*
        *
        *  if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            mLayoutManagerSavedState = bundle.getParcelable(SAVED_LAYOUT_MANAGER);
            state = bundle.getParcelable(SAVED_SUPER_STATE);
        }
        super.onRestoreInstanceState(state);*//*

        recyclerView.getLayoutManager().onRestoreInstanceState(savedInstanceState.getParcelable(KEY_RECYCLER_STATE));

        super.onRestoreInstanceState(savedInstanceState);


    }




    private void restoreLayoutManagerPosition() {
        Bundle test = new Bundle();

        recyclerView.getLayoutManager().onRestoreInstanceState(test.getParcelable(KEY_RECYCLER_STATE));
        Toast.makeText(this, "restore",
                Toast.LENGTH_LONG).show();


    }

 */
/*   public void setItems() {

        recyclerView.setAdapter(mAdapter);

        recyclerView.getLayoutManager().onRestoreInstanceState();

       // recyclerView.getLayoutManager().onRestoreInstanceState(test.getParcelable(KEY_RECYCLER_STATE));

    }
*//*






    */
/*  @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, recyclerView.getLayoutManager().onSaveInstanceState());
    }*//*




    */
/*
    *
    *    // save RecyclerView state
        mBundleRecyclerViewState = new Bundle();
        Parcelable listState = mRecyclerView.getLayoutManager().onSaveInstanceState();
        mBundleRecyclerViewState.putParcelable(KEY_RECYCLER_STATE, listState);*//*


    @Override
    protected void onPause() {

        //   Log.d(TAG, "saving listview state @ onPause");
        state = recyclerView.getLayoutManager().onSaveInstanceState();
        super.onPause();
        // setCNN("saved");
        setDataFromSharedPreferences(_mov);
        Log.i("tag", "saved on pause");
        Log.i("_mov", "mov" + getDataFromSharedPreferences());

        //  mBundleRecyclerViewState = new Bundle();
*/
/*
        lastFirstVisiblePosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();*//*

    }

    @Override
    protected void onResume() {
        super.onResume();
    */
/*    Toast.makeText(this, "restore",
                Toast.LENGTH_LONG).show();

        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPosition(lastFirstVisiblePosition);*//*

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // setCNN("saved");
    }

*/

}
