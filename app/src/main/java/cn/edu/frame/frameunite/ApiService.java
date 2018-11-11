package cn.edu.frame.frameunite;

import java.util.Map;


import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiService {
    @FormUrlEncoded
    @POST("api.php?req=userReg")
    Observable<BaseResult> getLogin(@FieldMap Map<String,String> params);
}
