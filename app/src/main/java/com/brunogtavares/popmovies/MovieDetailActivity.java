package com.brunogtavares.popmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.brunogtavares.popmovies.model.Movie;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String MOVIE_BUNDLE_KEY = "MOVIE_KEY";

    private ImageView mBackdrop;
    private ImageView mPosterThumbnail;
    private TextView mMovieRating;
    private TextView mDateReleased;
    private TextView mSinopsys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Movie movie = (Movie) getIntent().getParcelableExtra(MOVIE_BUNDLE_KEY);

        mBackdrop = (ImageView)  findViewById(R.id.iv_movie_backdrop);
        mPosterThumbnail = (ImageView) findViewById(R.id.iv_movie_poster_thumbnail);
        mMovieRating = (TextView) findViewById(R.id.tv_rating);
        mDateReleased = (TextView) findViewById(R.id.tv_date_released);
        mSinopsys = (TextView) findViewById(R.id.tv_synopsis);

        Picasso.with(this).load(movie.getBackDropPath()).into(mBackdrop);
        Picasso.with(this).load(movie.getPosterPath()).into(mPosterThumbnail);
        mMovieRating.setText(Double.toString(movie.getRating()) + "/10");
        mDateReleased.setText(movie.getReleaseDate());
        mSinopsys.setText(movie.getSynopsis());

    }
}
