package com.example.enviro2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DailytasklayoutAdapter extends RecyclerView.Adapter<DailytasklayoutAdapter.ViewHolder> {

    private List<DailytasklayoutModel> dailytasklayoutModelList;

    public DailytasklayoutAdapter(List<DailytasklayoutModel> dailytasklayoutModelList) {
        this.dailytasklayoutModelList = dailytasklayoutModelList;
    }

    @NonNull
    @Override
    public DailytasklayoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.daily_task_item_layout,viewGroup,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DailytasklayoutAdapter.ViewHolder viewholder, int position) {
       int resource = dailytasklayoutModelList.get(position).getDailytaskImage();
       String taskno = dailytasklayoutModelList.get(position).getDailytaskNo();
       String body = dailytasklayoutModelList.get(position).getDailytaskBody();
       String date = dailytasklayoutModelList.get(position).getDailytaskDate();

       viewholder.setDailytaskImage(resource);
       viewholder.setDailytaskNo(taskno);
       viewholder.setDailytaskBody(body);
       viewholder.setDailytaskDate(date);

    }

    @Override
    public int getItemCount() {
        return dailytasklayoutModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView dailytaskImage;
        private TextView dailytaskNo;
        private TextView dailytaskBody;
        private TextView dailytaskDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dailytaskImage = itemView.findViewById(R.id.dailytask_imageView);
            dailytaskNo = itemView.findViewById(R.id.dailytask_no);
            dailytaskBody = itemView.findViewById(R.id.dailytask_body);
            dailytaskDate = itemView.findViewById(R.id.dailytask_date);
        }

        private void setDailytaskImage(int resource) {
            dailytaskImage.setImageResource(resource);
        }

        private void  setDailytaskNo(String dailytaskno) {
            dailytaskNo.setText(dailytaskno);
        }

        private void  setDailytaskBody(String dailytaskbody) {
            dailytaskBody.setText(dailytaskbody);
        }

        private void setDailytaskDate(String dailytaskdate) {
            dailytaskDate.setText(dailytaskdate);
        }
    }
}
