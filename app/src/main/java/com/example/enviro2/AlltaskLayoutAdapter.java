package com.example.enviro2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlltaskLayoutAdapter extends RecyclerView.Adapter<AlltaskLayoutAdapter.ViewHolder> {

    private List<AlltaskLayoutModel> alltaskLayoutModelList;

    public AlltaskLayoutAdapter(List<AlltaskLayoutModel> alltaskLayoutModelList) {
        this.alltaskLayoutModelList = alltaskLayoutModelList;
    }

    @NonNull
    @Override
    public AlltaskLayoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.all_task_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlltaskLayoutAdapter.ViewHolder viewholder, int position) {
        int resource = alltaskLayoutModelList.get(position).getAlltaskImage();
        String taskno = alltaskLayoutModelList.get(position).getAlltaskNo();
        String body = alltaskLayoutModelList.get(position).getAlltaskBody();
        String date = alltaskLayoutModelList.get(position).getAlltaskDate();


        viewholder.setAlltaskImage(resource);
        viewholder.setAlltaskNo(taskno);
        viewholder.setAlltaskBody(body);
        viewholder.setAlltaskDate(date);
    }

    @Override
    public int getItemCount()
    {
        return alltaskLayoutModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView alltaskImage;
        private TextView alltaskNo;
        private TextView alltaskBody;
        private TextView alltaskDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            alltaskImage = itemView.findViewById(R.id.alltask_imageView);
            alltaskNo = itemView.findViewById(R.id.alltask_no);
            alltaskBody = itemView.findViewById(R.id.alltask_body);
            alltaskDate = itemView.findViewById(R.id.alltask_date);
        }

        private void setAlltaskImage(int resource) {
            alltaskImage.setImageResource(resource);
        }

        private void  setAlltaskNo(String alltaskno) {
            alltaskNo.setText(alltaskno);
        }

        private void  setAlltaskBody(String alltaskbody) {
            alltaskBody.setText(alltaskbody);
        }

        private void setAlltaskDate(String alltaskdate) {
            alltaskDate.setText(alltaskdate);
        }
    }
}
