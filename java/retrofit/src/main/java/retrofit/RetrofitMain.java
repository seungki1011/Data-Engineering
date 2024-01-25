package retrofit;

import retrofit2.Call;
import java.io.IOException;

public class RetrofitMain {
    public static void main(String[] args) {
        Call<Object> retrofitTest = RetrofitClient.getAPI().retrofitTest(2);

        try {
            System.out.println(retrofitTest.execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
