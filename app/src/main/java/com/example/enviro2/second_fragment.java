package com.example.enviro2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class second_fragment extends Fragment {

    private RecyclerView rewardsRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second,container,false);

        rewardsRecyclerView = view.findViewById(R.id.reward_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rewardsRecyclerView.setLayoutManager(layoutManager);
        List<Reward_Model> rewardModelList = new ArrayList<>();
        rewardModelList.add(new Reward_Model("Gift1","till 2nd,june 2020","GET 20 ruppees on first time login and registeration"));
        rewardModelList.add(new Reward_Model("Gift2","till 2nd,june 2020","GET 20 ruppees on first time login and registeration"));
        rewardModelList.add(new Reward_Model("Gift3","till 2nd,june 2020","GET 20 ruppees on first time login and registeration"));
        rewardModelList.add(new Reward_Model("Gift4","till 2nd,june 2020","GET 20 ruppees on first time login and registeration"));
        rewardModelList.add(new Reward_Model("Gift5","till 2nd,june 2020","GET 20 ruppees on first time login and registeration"));
        rewardModelList.add(new Reward_Model("Gift6","till 2nd,june 2020","GET 20 ruppees on first time login and registeration"));
        rewardModelList.add(new Reward_Model("Gift7","till 2nd,june 2020","GET 20 ruppees on first time login and registeration"));

        Reward_Adapter rewardAdapter = new Reward_Adapter(rewardModelList);
        rewardsRecyclerView.setAdapter(rewardAdapter);
        rewardAdapter.notifyDataSetChanged();








        //For BACKGROUND ANIMATION//
       // FrameLayout frameLayout = view.findViewById(R.id.second_layout);
       // AnimationDrawable animationDrawable = (AnimationDrawable) frameLayout.getBackground();
       // animationDrawable.setEnterFadeDuration(2000);
       // animationDrawable.setExitFadeDuration(4000);
       // animationDrawable.start();
        return view;
    }

}
