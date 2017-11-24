package com.example.frana.animapets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by frana on 24/11/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<List_vitrine_cards> listItems;
    private Context context;

    public RecyclerViewAdapter(List<List_vitrine_cards> listItem, Context context) {
        this.listItems = listItem;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List_vitrine_cards listItem = listItems.get(position);

        holder.descText.setText(listItem.getDesc());
       // holder.imageProd.setImageBitmap(listItem.getImage());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView descText;
        public ImageView imageProd;
        public Button add_button_car;

        public ViewHolder(View itemView) {
            super(itemView);

            descText = (TextView) itemView.findViewById(R.id.text_info_product_card);
            imageProd = (ImageView) itemView.findViewById(R.id.produto_imageView);
            add_button_car = (Button) itemView.findViewById(R.id.add_carrinho_btn_vitrine);
        }
    }
}
