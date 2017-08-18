package Services;

import java.util.List;

import Model.Doc;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by janhu on 18.08.2017.
 */

public interface DocService {

    @GET("docs/all/")
    Call<List<Doc>> loadAllDocs();
}