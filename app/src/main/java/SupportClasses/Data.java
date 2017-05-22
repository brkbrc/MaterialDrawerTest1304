package SupportClasses;

import android.support.annotation.NonNull;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

/**
 * Created by commander on 17.05.2017.
 */

public class Data implements SortedListAdapter.ViewModel {
    public String title;
    public String description;
    public int imageId;
    public int id;

    public Data(int id, String title, String description, int imageId) {
        this.title = title;
        this.description = description;
        this.imageId = imageId;
        this.id=id;
    }

    public String getText() {
        return title;
    }

    public long getId() {
        return id;
    }

    @Override
    public <T> boolean isSameModelAs(@NonNull T t) {
        return false;
    }

    @Override
    public <T> boolean isContentTheSameAs(@NonNull T t) {
        return false;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data model = (Data) o;

        if (id != model.id) return false;
        return title != null ? title.equals(model.title) : model.title == null;
    }



    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }




}
