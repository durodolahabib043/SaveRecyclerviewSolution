package info.androidhive.recyclerview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreference {

    public static final String PREFS_NAME = "PRODUCT_APP";
    public static final String FAVORITES = "Product_Favorite";
    public static final String CCN = "cnn";
    SharedPreferences settings;
    Editor editor;

    public SharedPreference() {
        super();
    }

    // This four methods are used for maintaining favorites.
    public void saveFavorites(Context context, List<Movie> favorites) {


        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public void setCNN(Context context, String cnn) {
        settings = context.getSharedPreferences(CCN,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        // editor.clear();
        editor.putString(CCN, cnn);
        editor.commit();
    }

    public String getCNN(Context context) {

        settings = context.getSharedPreferences(CCN,
                Context.MODE_PRIVATE);
        return settings.getString(CCN, null);
    }


    public void addFavorite(Context context, Movie product) {
        List<Movie> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<Movie>();
        favorites.add(product);
        //	favorites.add(0 ,new Movie(product.getTitle() , product.getGenre(), product.getYear()));
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, Movie product) {
        ArrayList<Movie> favorites = getFavorites(context);
        if (favorites != null) {
            //favorites.remove( new Movie(product.getTitle() , product.getGenre() , product.getYear())) ;
            favorites.remove(product);
            saveFavorites(context, favorites);
        }
    }

    public ArrayList<Movie> getFavorites(Context context) {
        SharedPreferences settings;
        List<Movie> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Movie[] favoriteItems = gson.fromJson(jsonFavorites,
                    Movie[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Movie>(favorites);
        } else
            return null;

        return (ArrayList<Movie>) favorites;
    }
}
