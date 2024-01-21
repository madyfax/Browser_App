package browser.demo.mbrowserapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AppItemAdapter extends RecyclerView.Adapter<AppItemAdapter.set>{

    ArrayList<AppItem> appItems;
    ArrayList<AppItem> shopping;
    Context context;
    Myclick myclick;



    public AppItemAdapter(ArrayList<AppItem> appItems, Context context, Myclick myclick) {
        this.appItems = appItems;
        this.context = context;
        shopping=new ArrayList<>();
        shopping.addAll(appItems);
        this.myclick = myclick;
    }

    @NonNull
    @Override
    public set onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.app_item,parent,false);
        return new set(view);
    }

    @Override
    public void onBindViewHolder(@NonNull set holder, int position) {
        holder.tv.setText(appItems.get(position).getName());
        holder.tv.setText(shopping.get(position).getName());
        Glide.with(context).load(appItems.get(position).getIcon()).into(holder.iv);
        Glide.with(context).load(shopping.get(position).getIcon()).into(holder.iv);
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myclick.link(position);
                MyApp.setlink(appItems.get(position).getLink());
            }
        });

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myclick.link(position);
                MyApp.setlink(shopping.get(position).getLink());
            }
        });
    }

    @Override
    public int getItemCount() {
        return appItems.size();
    }

    public class set extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tv;
        LinearLayout linear;
        public set(@NonNull View itemView) {
            super(itemView);

            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
            linear=itemView.findViewById(R.id.linear);
        }
    }


    public interface Myclick{
        public void link(int pos);
    }
}

