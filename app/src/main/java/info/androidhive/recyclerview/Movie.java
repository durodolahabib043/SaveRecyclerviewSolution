package info.androidhive.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lincoln on 15/01/16.
 */
public class Movie  implements Parcelable{
    private String title, genre, year;
    private int position;

    public Movie() {
    }

    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

  /*  public Movie(int position, String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.position = position ;
    }
*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    // public  void  add (int)


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public Movie(Parcel in) {
        super();
        readFromParcel(in);
    }
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {

            return new Movie[size];
        }

    };

    public void readFromParcel(Parcel in) {

        /*
        *    this.title = title;
        this.genre = genre;
        this.year = year;*/
        this.title = in.readString();
        this.genre = in.readString();
        this.year = in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(title);
        dest.writeString(genre);
        dest.writeString(year);

    }
}
