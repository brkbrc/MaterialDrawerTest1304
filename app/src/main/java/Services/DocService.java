package Services;

import java.util.List;

import Model.Doc;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by janhu on 18.08.2017.
 */

public interface DocService {

    @GET("docs/all/")
    Call<List<Doc>> loadAllDocs();

    @GET("docs/search")
    Call<List<Doc>> searchDocs(
            @Query("lastName") String lastName,
            @Query("speciality") String speciality,
            @Query("city") String city);
}