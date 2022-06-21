package agolubeff.cardviewswiperefreshtemplate.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import agolubeff.cardviewswiperefreshtemplate.R;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
{
    private Context context;
    private List<String> list;

    public MyAdapter(Context context, List<String> list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        MyViewHolder pvh = new MyViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {
        holder.text.setText(list.get(position));
    }
}

class MyViewHolder extends RecyclerView.ViewHolder
{
    CardView card_view;
    TextView text;

    MyViewHolder(View item)
    {
        super(item);

        card_view = item.findViewById(R.id.card_view);
        text = item.findViewById(R.id.text);
    }
}