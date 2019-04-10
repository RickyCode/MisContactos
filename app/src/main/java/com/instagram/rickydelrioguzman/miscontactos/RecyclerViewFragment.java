package com.instagram.rickydelrioguzman.miscontactos;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerViewFragment extends Fragment {
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Asociación del código java con el formato XML
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false); // Equivale al "setContentView"  de una activity
        return v;
    }
    
}
