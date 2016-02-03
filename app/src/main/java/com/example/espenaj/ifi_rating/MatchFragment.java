package com.example.espenaj.ifi_rating;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.espenaj.ifi_rating.adapter.ChessMatchAdapter;
import com.example.espenaj.ifi_rating.model.ChessMatch;
import com.example.espenaj.ifi_rating.model.Match;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MatchFragment extends Fragment implements MainActivity.FragmentComm {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    String LogTag = "MatochFragment";
    MainActivity.FragmentComm fragmentComm;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MatchFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MatchFragment newInstance(int columnCount) {
        Log.d("Match", "new instance (int)");
        MatchFragment fragment = new MatchFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);

        return fragment;
    }

    public static MatchFragment newInstance(ArrayList<Match> matches) {
        MatchFragment fragment = new MatchFragment();

        Bundle args = new Bundle();
        args.putParcelableArrayList("matches", matches);
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public void onResume() {
        Log.d("Match", "onResume");
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_list, container, false);


        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Match", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.d(LogTag, "OnoCreateView");
        setRetainInstance(true);

        Bundle args = getArguments();
      //  ArrayList<Match> m = args.getParcelableArrayList("matches");

        Log.d("Match", " " + MainActivity.MATCHES.size());
       // Log.d("Match", " " + m.size());


        if(MainActivity.MATCHES.size() == 0) {
            Log.d(LogTag, "Matches size is 0!");
        }

        // Set the adapter
        if (view instanceof RecyclerView) {
            Log.d(LogTag, "View is RecyclerView");
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setHasFixedSize(true);

            LinearLayoutManager llm = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(llm);

                Log.d(LogTag, "Matches is type ChessMatch");
                ChessMatchAdapter adapter = new ChessMatchAdapter(MainActivity.MATCHES);
                recyclerView.setAdapter(adapter);
                Log.d(LogTag, "" + adapter);
        } else {
            Log.d(LogTag, "View is NOT RecyclerView");
        }
        return view;
    }

    public void updateMatchList() {
        // Set the adapter
        Log.d(LogTag, "UpdateMatchList");
        View view = getView();
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(llm);

            if(MainActivity.MATCHES.get(0) instanceof ChessMatch) {
                ChessMatchAdapter adapter = new ChessMatchAdapter(MainActivity.MATCHES);
                recyclerView.setAdapter(adapter);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LogTag, "onStart");
    }

    @Override
    public void onAttach(Context context) {
        Log.d("Match", "On attach");
        super.onAttach(context);

        fragmentComm = new MainActivity.FragmentComm() {
            @Override
            public void onMatchDataDownloaded(List<ChessMatch> matches) {
                onMatchDataDownloaded(matches);
            }
        };


        Log.d(LogTag, "Interface created!!!");


        // Set the adapter
        View view = getView();
        if (getView() instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(llm);

            if (MainActivity.MATCHES.get(0) instanceof ChessMatch) {
                ChessMatchAdapter adapter = new ChessMatchAdapter(MainActivity.MATCHES);
                recyclerView.setAdapter(adapter);
            }
        }

        /*
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMatchDataDownloaded(List<ChessMatch> matches) {
        Log.d(LogTag, "onMatchDownloaded");

        // Set the adapter
        if (getView() instanceof RecyclerView) {
            Context context = getView().getContext();
            RecyclerView recyclerView = (RecyclerView) getView();
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(llm);

            if(MainActivity.MATCHES.get(0) instanceof ChessMatch) {
                ChessMatchAdapter adapter = new ChessMatchAdapter(MainActivity.MATCHES);
                recyclerView.setAdapter(adapter);
            }
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Match item);
    }

}
