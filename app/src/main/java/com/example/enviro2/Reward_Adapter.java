package com.example.enviro2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Reward_Adapter extends RecyclerView.Adapter<Reward_Adapter.Viewholder>  {

    private List<Reward_Model> rewardModelList;

    public Reward_Adapter(List<Reward_Model> rewardModelList) {
        this.rewardModelList = rewardModelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rewards_item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        String title = rewardModelList.get(position).getTitle();
        String date = rewardModelList.get(position).getExpirydate();
        String body = rewardModelList.get(position).getCouponbody();
        viewholder.setData(title,date,body);



    }

    @Override
    public int getItemCount() {
        return rewardModelList.size();
    }

    public class Viewholder  extends  RecyclerView.ViewHolder{

        private TextView coupontitle;
        private TextView couponExpirydate;
        private TextView  couponbody;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            coupontitle = itemView.findViewById(R.id.coupon_title);
            couponExpirydate = itemView.findViewById(R.id.coupon_validity);
            couponbody = itemView.findViewById(R.id.coupon_body);

        }
        private void setData(String title,String date,String body){
            coupontitle.setText(title);
            couponExpirydate.setText(date);
            couponbody.setText(body);
        }
    }
}
