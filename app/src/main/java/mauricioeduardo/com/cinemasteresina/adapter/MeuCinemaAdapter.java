package mauricioeduardo.com.cinemasteresina.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

import mauricioeduardo.com.cinemasteresina.R;
import mauricioeduardo.com.cinemasteresina.model.Filme;

/**
 * Created by mauricioedu on 26/12/17.
 */

public class MeuCinemaAdapter extends  RecyclerView.Adapter<MeuCinemaAdapter.MyViewHolder> {



    private Context mContext;
    private List<Filme> filmeList = new ArrayList<>();



    public MeuCinemaAdapter(Context mContext, List<Filme> filmeList) {
        this.filmeList = filmeList;
        this.mContext = mContext;
    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_row_view, parent, false);

        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Filme filme = filmeList.get(position);
        holder.titulo.setText(filme.getTitulo());
        String thumbnail = filme.getCartaz();

        Glide.with(mContext)
                .load(thumbnail)
                .into(holder.cartaz);

    }


    @Override
    public int getItemCount(){
        return filmeList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView titulo;
        ImageView cartaz;

        public MyViewHolder(View view){

            super(view);
            titulo = (TextView) view.findViewById(R.id.title);
            cartaz = (ImageView) view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
//                        Recipe clickedDataItem = recipeList.get(pos);
//
//                        Intent intent = new Intent(mContext, RecipeDetailActivity.class);
//                        intent.putExtra("Recipe", clickedDataItem);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        mContext.startActivity(intent);
//                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}