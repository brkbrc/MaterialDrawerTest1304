package Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.medicusApp.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by burak-thinkpad on 18.08.2017.
 */

public class Expandable_list_adapter extends BaseExpandableListAdapter{
    private List<String> header_titles;
    private HashMap<String,List<String>> child_titles;
    private Context ctx;


    Expandable_list_adapter(Context ctx, List<String> header_titles, HashMap<String,List<String>>  child_titles){
        this.ctx=ctx;
        this.child_titles=child_titles;
        this.header_titles=header_titles;
    }

    @Override
    public int getGroupCount() {
        return header_titles.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child_titles.get(header_titles.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return header_titles.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child_titles.get(header_titles.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title=(String)this.getGroup(i);
        if(view==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.parent_expandable_list_layout,null);
        }
        TextView textView = (TextView) view.findViewById(R.id.expandable_list_heading_item);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);


        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) this.getChild(i,i1);
        if(view==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_expandable_list_layout,null);
        }
        TextView textView = (TextView) view.findViewById(R.id.expandable_list_child_item);

        textView.setText(title);


        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
