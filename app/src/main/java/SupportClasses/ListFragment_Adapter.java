package SupportClasses;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import Fragments.DoctorFragment;
import com.example.MedicusApp.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by commander on 17.05.2017.
 */

public class ListFragment_Adapter extends RecyclerView.Adapter<View_Holder> {

    List<Data> list = Collections.emptyList();
    Context context;

    public ListFragment_Adapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }




    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_cardview_layout, parent, false);
        View_Holder holder = new View_Holder(v);
//        holder.cv.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                //v.getContext().startActivity(new Intent(v.getContext(),LoginActivity.class));
//                context.startActivity(new Intent(context,LoginActivity.class));
//            }
//
//        });

        return holder;
    }

    @Override
    public void onBindViewHolder(View_Holder holder, final int position) {

        holder.title.setText(list.get(position).title);
        holder.description.setText(list.get(position).description);
        holder.imageView.setImageResource(list.get(position).imageId);

        holder.cv.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                //Toast.makeText(view.getContext(), "You have clicked " + view.getId(), Toast.LENGTH_SHORT).show(); //you can add data to the tag of your cardview in onBind... and retrieve it here with with.getTag().toString()..

                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                //TODO
                //Doktorfragment mit Constructor versehen damit die richtigen Daten erhoben werden
                DoctorFragment myFragment = new DoctorFragment((list.get(position).title));

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.constraintlayout_for_fragment, myFragment).addToBackStack(null).commit();
            }

        });

        //animate(holder);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView
    public void insert(int position, Data data) {
        list.add(position, data);
        notifyItemInserted(position);
    }
    // Remove a RecyclerView item containing the Data object
    public void remove(Data data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.anticipate_overshoot_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }

}
