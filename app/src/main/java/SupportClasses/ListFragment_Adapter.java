package SupportClasses;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import Fragments.DoctorFragment;
import com.example.medicusApp.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by commander on 17.05.2017.
 */

public class ListFragment_Adapter extends RecyclerView.Adapter<View_Holder> {

    List<Data> list = Collections.emptyList();
    Context context;
    private final Comparator<Data> mComparator;


    private final SortedList<Data> mSortedList = new SortedList<>(Data.class, new SortedList.Callback<Data>(){

        @Override
        public void onInserted(int position, int count) {
            notifyItemRangeInserted(position, count);

        }

        @Override
        public void onRemoved(int position, int count) {
            notifyItemRangeRemoved(position, count);

        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            notifyItemMoved(fromPosition, toPosition);

        }

        /*
        Compare Method
        Der Comperator ist in der Activity drin und wird als parameter diesem Adapter gegeben
        Alphabetische Ordnung bei Suche
         */
        @Override
        public int compare(Data a, Data b) {
            return mComparator.compare(a,b);
        }

        @Override
        public void onChanged(int position, int count) {
            notifyItemRangeChanged(position, count);
        }

        /*
        Diese Methode vergleicht die Datenobjekte anhand ihres Contents, ggf. mit einer Hashmethode (siehe Data)
         */
        @Override
        public boolean areContentsTheSame(Data oldItem, Data newItem) {
            return oldItem.equals(newItem);
        }

        //Diese Methode vergleicht die Datenobjekte anhand ihrer ID)
        @Override
        public boolean areItemsTheSame(Data item1, Data item2) {
            return item1.getId() == item2.getId();
        }
    });

    public ListFragment_Adapter(List<Data> list, Context context, Comparator<Data> mComparator) {
        this.list = list;
        this.context = context;
        this.mComparator = mComparator;
    }




    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_cardview_layout, parent, false);
        View_Holder holder = new View_Holder(v);
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
        //Beispiel Toast:
        //Toast.makeText(view.getContext(), "You have clicked " + view.getId(), Toast.LENGTH_SHORT).show(); //you can add data to the tag of your cardview in onBind... and retrieve it here with with.getTag().toString()..

        AppCompatActivity activity = (AppCompatActivity) view.getContext(); //Aktivität herbekommen + Hier würde auch context alleine reichen




        //DoktorFragment wird jetzt aufgerufen wenn man auf eine Cardview klickt
        //Doktorfragment mit Constructor versehen damit die richtigen Daten erhoben werden
        DoctorFragment myFragment = new DoctorFragment((list.get(position).title));
        activity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                .replace(R.id.constraintlayout_for_fragment, myFragment)
                .addToBackStack(null) //addtobackstack sichert die korrekte Reihenfolge beim Drücken des Back Buttons
                .commit();

            }

        });
        //animate(holder); //Animation ausgeschaltet
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

    public void replaceAll(List<Data> models) {
        mSortedList.beginBatchedUpdates();
        for (int i = mSortedList.size() - 1; i >= 0; i--) {
            final Data model = mSortedList.get(i);
            if (!models.contains(model)) {
                mSortedList.remove(model);
            }
        }
        mSortedList.addAll(models);
        mSortedList.endBatchedUpdates();
    }

    public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.anticipate_overshoot_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }

}
