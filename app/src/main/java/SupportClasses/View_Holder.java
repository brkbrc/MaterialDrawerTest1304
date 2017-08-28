package SupportClasses;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medicusApp.R;

/**
 * Created by commander on 17.05.2017.
 */

public class View_Holder extends RecyclerView.ViewHolder {

    public CardView cv;
    public ImageView iv_doc;
    public TextView tv_name;
    public TextView tv_address;
    public TextView tv_speciality;
    public TextView tv_distance;


   public View_Holder(View itemView) {
       super(itemView);
       cv = (CardView) itemView.findViewById(R.id.cv_doclist);
       iv_doc = (ImageView) itemView.findViewById(R.id.cv_doclist_iv_doc);
       tv_name = (TextView) itemView.findViewById(R.id.cv_doclist_tv_name);
       tv_address = (TextView) itemView.findViewById(R.id.cv_doclist_tv_address);
       tv_speciality = (TextView) itemView.findViewById(R.id.cv_doclist_tv_speciality);
       tv_distance = (TextView) itemView.findViewById(R.id.cv_doclist_tv_distance);
   }

}