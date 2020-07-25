package com.example.enviro2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment implements View.OnClickListener {
    private onFragmentBtnSelected listener;

    ////DailyTaskLayout
    private TextView dailyTasklayoutTitle;
    private RecyclerView dailyTaskRecyclerView;
    ////DailyTaskLayout

    ////AllTaskLayout
    private TextView allTasklayoutTitle;
    private RecyclerView allTaskRecyclerView;

    ////AllTaskLayout

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main,container,false);

        ////DailyTaskLayout
        dailyTasklayoutTitle = view.findViewById(R.id.daily_task_title);
        dailyTaskRecyclerView = view.findViewById(R.id.dailytask_layout_recyclerview);

        List<DailytasklayoutModel> dailytasklayoutModelList = new ArrayList<>();
        dailytasklayoutModelList.add(new DailytasklayoutModel(R.drawable.plant,"Task 1","Plant a little tulsi plant","21 SUNDAY"));
        dailytasklayoutModelList.add(new DailytasklayoutModel(R.drawable.coffee_cup,"Task 2","Plant a little tulsi plant2","21 SUNDAY"));
        dailytasklayoutModelList.add(new DailytasklayoutModel(R.drawable.gift512,"Task 3","Plant a little tulsi plant3","21 SUNDAY"));

        DailytasklayoutAdapter dailytasklayoutAdapter =new DailytasklayoutAdapter(dailytasklayoutModelList);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        dailyTaskRecyclerView.setLayoutManager(linearLayoutManager1);

        dailyTaskRecyclerView.setAdapter(dailytasklayoutAdapter);
        dailytasklayoutAdapter.notifyDataSetChanged();
        ////DailyTaskLayout

        //////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        ///AllTaskLayout

        allTasklayoutTitle = view.findViewById(R.id.all_task_title);
        allTaskRecyclerView = view.findViewById(R.id.alltask_layout_recyclerview);
        allTaskRecyclerView.setNestedScrollingEnabled(false);

        List<AlltaskLayoutModel> alltasklayoutModelList = new ArrayList<>();
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.plant,"Task 1","Plant a little tulsi plant","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.coffee_cup,"Task 2","Plant a little tulsi plant2","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 3","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 4","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 5","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 6","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 7","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 8","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 9","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 10","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 11","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 12","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 13","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 14","Plant a little tulsi plant3","21 SUNDAY"));
        alltasklayoutModelList.add(new AlltaskLayoutModel(R.drawable.gift512,"Task 15","Plant a little tulsi plant3","21 SUNDAY"));

        AlltaskLayoutAdapter alltasklayoutAdapter =new AlltaskLayoutAdapter(alltasklayoutModelList);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        allTaskRecyclerView.setLayoutManager(linearLayoutManager2);

        allTaskRecyclerView.setAdapter(alltasklayoutAdapter);
        alltasklayoutAdapter.notifyDataSetChanged();

        ///AllTaskLayout
        ////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof onFragmentBtnSelected){
           listener = (onFragmentBtnSelected) context;
;       }
     else {
        throw new ClassCastException(context.toString() + " must implement listner");
        }


    }

    @Override
    public void onClick(View v) {
        FirebaseAuth.getInstance().signOut();

    }

    public interface onFragmentBtnSelected{
        public void onButtonSelected();
    }



}
