package be.teknyske.recycling;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Collections;
import java.util.List;

import static android.R.attr.animation;

/**
 * Created by cerseilannister on 19/10/16.
 */


public class MovieListAdapter extends RecyclerView.Adapter<MovieViewHolder>
{
    private Context context;
    private List<Movie> movieList = Collections.emptyList();

    public MovieListAdapter(List<Movie> movieList, Context context)
        {
        this.movieList = movieList;
        this.context = context;
        }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
        // load XML and create viewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MovieViewHolder(view);
        }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position)
        {
        // Conversie van velden uit Movie-object naar elementen van ViewHolder
        Movie currentMovie = movieList.get(position);
        holder.getTitleTextView().setText(currentMovie.getTitle());
        holder.getDescriptionTextview().setText(currentMovie.getDescription());
        holder.getImageView().setImageResource(currentMovie.getPoster());
        animate(holder);
        }

    @Override
    public int getItemCount()
        {
        return movieList.size();
        }

    public void insertMovie(int position,Movie movie)
        {
        movieList.add(position,movie);
        notifyItemInserted(position);
        }

    public void removeMovie (Movie movie)
        {
        int position = movieList.indexOf(movie);
        movieList.remove(position);
        notifyItemRemoved(position);
        }

    public void animate (RecyclerView.ViewHolder viewHolder)
        {
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.bounce_animation);
        viewHolder.itemView.setAnimation(animation);
        }



}
