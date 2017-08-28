package Adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.medicusApp.R;

import java.util.Collections;
import java.util.List;

import Fragments.DoctorFragment;
import Model.Doc;
import SupportClasses.View_Holder;

import static com.example.medicusApp.R.drawable.placeholder_woman;

/**
 * Created by commander on 17.05.2017.
 * //resr
 */

public class ListFragment_Adapter extends RecyclerView.Adapter<View_Holder> {

    List<Doc> list = Collections.emptyList();
    Context context;
    //private final Comparator<Doc> mComparator;


//    private final SortedList<Doc> mSortedList = new SortedList<>(Doc.class, new SortedList.Callback<Doc>(){
//
//        @Override
//        public void onInserted(int position, int count) {
//            notifyItemRangeInserted(position, count);
//
//        }
//
//        @Override
//        public void onRemoved(int position, int count) {
//            notifyItemRangeRemoved(position, count);
//
//        }
//
//        @Override
//        public void onMoved(int fromPosition, int toPosition) {
//            notifyItemMoved(fromPosition, toPosition);
//
//        }
//
//        /*
//        Compare Method
//        Der Comperator ist in der Activity drin und wird als parameter diesem Adapter gegeben
//        Alphabetische Ordnung bei Suche
//         */
//        @Override
//        public int compare(Doc a, Doc b) {
//            return mComparator.compare(a,b);
//        }
//
//        @Override
//        public void onChanged(int position, int count) {
//            notifyItemRangeChanged(position, count);
//        }
//
//        /*
//        Diese Methode vergleicht die Datenobjekte anhand ihres Contents, ggf. mit einer Hashmethode (siehe Data)
//         */
//        @Override
//        public boolean areContentsTheSame(Doc oldItem, Doc newItem) {
//            return oldItem.equals(newItem);
//        }
//
//        //Diese Methode vergleicht die Datenobjekte anhand ihrer ID)
//        @Override
//        public boolean areItemsTheSame(Doc item1, Doc item2) {
//            return item1.getId() == item2.getId();
//        }
//    });


//    //Constructor
//    public ListFragment_Adapter( Context context, Comparator<Doc> mComparator) {
//        this.context = context;
//        this.mComparator = mComparator;
//    }

    public ListFragment_Adapter (Context context, List<Doc> docs) {
        this.context = context;
        this.list = docs;
    }





    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_cardview_layout, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(View_Holder holder, final int position) {

        final Doc docItem = list.get(position);
        String name = docItem.getTitle() + " " + docItem.getFirstName() + " " + docItem.getLastName();

        holder.tv_name.setText(name);
        holder.tv_address.setText(docItem.getAddress().toString());
        holder.tv_speciality.setText(docItem.getSpeciality().toString());
        if(docItem.getGender() == 'f') {
            holder.iv_doc.setImageResource(placeholder_woman);
        }

        holder.cv.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
        //Beispiel Toast:
        //Toast.makeText(view.getContext(), "You have clicked " + view.getId(), Toast.LENGTH_SHORT).show(); //you can add listeArzte to the tag of your cardview in onBind... and retrieve it here with with.getTag().toString()..

        AppCompatActivity activity = (AppCompatActivity) view.getContext(); //Aktivität herbekommen + Hier würde auch context alleine reichen




        //DoktorFragment wird jetzt aufgerufen wenn man auf eine Cardview klickt
        //Doktorfragment mit Constructor versehen damit die richtigen Daten erhoben werden
                Doc doc = list.get(position);
        DoctorFragment myFragment = new DoctorFragment(doc.getTitle(), doc.getFirstName(), doc.getLastName());
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
//
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//    }
//
//    // Insert a new item to the RecyclerView
//    public void insert(Doc data) {
//        mSortedList.add(data);
//        //notifyItemInserted(position);
//    }
//
//
//    // Remove a RecyclerView item containing the Data object
//    public void remove(Doc data) {
//        mSortedList.remove(data);
//    }
//
//
//
//    public void replaceAll(List<Doc> models) {
//        mSortedList.beginBatchedUpdates();
//
//
//        for (int i = mSortedList.size() - 1; i >= 0; i--) {
//            final Doc model = mSortedList.get(i);
//            if (!models.contains(model)) {
//                mSortedList.remove(model);
//            }
//        }
//        mSortedList.addAll(models);
//        mSortedList.endBatchedUpdates();
//    }

    public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.anticipate_overshoot_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }

    public void erstelleListe(RecyclerView.ViewHolder viewHolder){
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.anticipate_overshoot_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }

}
