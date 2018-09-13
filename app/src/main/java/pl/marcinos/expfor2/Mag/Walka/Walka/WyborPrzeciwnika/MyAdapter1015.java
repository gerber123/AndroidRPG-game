package pl.marcinos.expfor2.Mag.Walka.Walka.WyborPrzeciwnika;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pl.marcinos.expfor2.Potwory.Potwory;
import pl.marcinos.expfor2.R;

/**
 * Created by marci on 19.03.2018.
 */
public class MyAdapter1015 extends BaseAdapter {
    private Context context;
    private List<Potwory> potworyList;
    private LayoutInflater layoutInflater;
    int[] Images = {R.drawable.guard, R.drawable.hellgate, R.drawable.rycerz};

    public MyAdapter1015(Context context, List<Potwory> potworyList)
    {
        this.context = context;
        this.potworyList = potworyList;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return potworyList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.customlayout510, parent, false);
            viewHolder.name = (TextView) convertView.findViewById((R.id.textView_name));
            viewHolder.hp = (TextView) convertView.findViewById((R.id.textView_hp));
            viewHolder.atk = (TextView) convertView.findViewById((R.id.textView_atk));
            viewHolder.img= (ImageView) convertView.findViewById((R.id.imageView5));
            viewHolder.lvl = (TextView) convertView.findViewById(R.id.textView_lvl);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.name.setText(potworyList.get(position).getName());
        viewHolder.hp.setText("Hp: " + potworyList.get(position).getHp());
        viewHolder.atk.setText("Atk: " + potworyList.get(position).getAtkDoListy());
        viewHolder.lvl.setText("Lvl:" + potworyList.get(position).getLvl());


        viewHolder.img.setImageResource(Images[position]);

        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView hp;
        TextView atk;
        ImageView img;
        TextView lvl;

    }
}



