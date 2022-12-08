package NhomTTPTT.example.BaiTapCuoiKi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.otpverification.R;

import java.util.List;

import NhomTTPTT.example.BaiTapCuoiKi.menu.ActivityFavorite;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MusicViewHolder> {
    private List<Movie> movieList;
    private Context mContext;

    public void setData(List<Movie> list){
        this.movieList =list;
        notifyDataSetChanged();
    }

    public MovieAdapter(List<Movie> movieList, Context mContext) {
        this.movieList = movieList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);
        Movie game = movieList.get(position);
        if(game==null){
            return;
        }else {
            holder.img_View.setImageResource(game.getImg());
            holder.txt_TenGame.setText(game.getMovieName());
            holder.txt_MoTa.setText(game.getLikes());
            holder.cv_onClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, ActivityDetail.class);
                    intent.putExtra("key1", movieList.get(position).getMovieName());
                    intent.putExtra("key2", movieList.get(position).getMovieSummary());
                    mContext.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if(!movieList.isEmpty()){
            return movieList.size();
        }
        return 0;
    }

    public  class MusicViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_View;
        private TextView txt_TenGame;
        private TextView txt_MoTa;
        private CardView cv_onClick;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            img_View = itemView.findViewById(R.id.img_movie);
            txt_TenGame =itemView.findViewById(R.id.txt_tenPhim);
            txt_MoTa =itemView.findViewById(R.id.txt_moTa);
            cv_onClick =itemView.findViewById(R.id.cv_Onclick);
        }
    }

}
