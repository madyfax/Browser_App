package browser.demo.mbrowserapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements AppItemAdapter.Myclick {
    RecyclerView rv,rv2;
    ImageView menu;
    //    SearchView search;
    ArrayList<AppItem> appItems = new ArrayList<>();
    ArrayList<AppItem> shopping = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        rv2 = findViewById(R.id.rv2);
        rv = findViewById(R.id.rv);
        menu = findViewById(R.id.menu);

        appItems.add(new AppItem("Flipkart", "https://www.freepnglogos.com/uploads/flipkart-logo-png/flipkart-inventory-management-system-zap-inventory-1.png", "https://www.flipkart.com/"));
        appItems.add(new AppItem("Amazon", "https://w7.pngwing.com/pngs/141/900/png-transparent-amazon-com-amazon-echo-amazon-music-the-everything-store-jeff-bezos-and-the-age-of-amazon-kindle-fire-black-friday-miscellaneous-text-logo.png", "https://www.amazon.in/"));
        appItems.add(new AppItem("Ajio", "https://searchlogovector.com/wp-content/uploads/2019/02/ajio-logo-vector.png", "https://www.ajio.com/"));
        appItems.add(new AppItem("Myntra", "https://www.freepnglogos.com/uploads/logo-myntra-png/myntra-logo-m-png-3.png", "https://www.myntra.com/"));
        appItems.add(new AppItem("Adidas", "https://i.pinimg.com/280x280_RS/89/27/18/892718ab333f14d55cdcb71c4e0d67a7.jpg", "https://www.adidas.co.in/"));
        appItems.add(new AppItem("Snitch", "https://images.yourstory.com/cs/images/companies/Snitch-1620061651111.jpg?fm=auto&ar=1:1&mode=fill&fill=solid&fill-color=fff", "https://www.snitch.co.in/"));


        shopping.add(new AppItem("Flipkart", "https://www.freepnglogos.com/uploads/flipkart-logo-png/flipkart-inventory-management-system-zap-inventory-1.png", "https://www.flipkart.com/"));
        shopping.add(new AppItem("Amazon", "https://w7.pngwing.com/pngs/141/900/png-transparent-amazon-com-amazon-echo-amazon-music-the-everything-store-jeff-bezos-and-the-age-of-amazon-kindle-fire-black-friday-miscellaneous-text-logo.png", "https://www.amazon.in/"));
        shopping.add(new AppItem("Ajio", "https://searchlogovector.com/wp-content/uploads/2019/02/ajio-logo-vector.png", "https://www.ajio.com/"));
        shopping.add(new AppItem("Myntra", "https://www.freepnglogos.com/uploads/logo-myntra-png/myntra-logo-m-png-3.png", "https://www.myntra.com/"));
        shopping.add(new AppItem("Adidas", "https://i.pinimg.com/280x280_RS/89/27/18/892718ab333f14d55cdcb71c4e0d67a7.jpg", "https://www.adidas.co.in/"));
        shopping.add(new AppItem("Snitch", "https://images.yourstory.com/cs/images/companies/Snitch-1620061651111.jpg?fm=auto&ar=1:1&mode=fill&fill=solid&fill-color=fff", "https://www.snitch.co.in/"));


        GridLayoutManager gridLayoutManager = new GridLayoutManager(HomeActivity.this, 3);
        rv.setLayoutManager(gridLayoutManager);

        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(HomeActivity.this, 3);
        rv2.setLayoutManager(gridLayoutManager1);
        AppItemAdapter appItemAdapter = new AppItemAdapter(appItems, HomeActivity.this, HomeActivity.this);
        rv.setAdapter(appItemAdapter);
        AppItemAdapter appItemAdapter1 = new AppItemAdapter(shopping, HomeActivity.this, HomeActivity.this);
        rv2.setAdapter(appItemAdapter1);


    }


    @Override
    public void link(int pos) {
        String link = appItems.get(pos).getLink();
        MyApp.setlink(link);
        MyApp.setMyList(appItems);
        MyApp.setmypos(pos);
        Intent intent = new Intent(HomeActivity.this, BrowserActivity.class);
        startActivity(intent);
    }
}
