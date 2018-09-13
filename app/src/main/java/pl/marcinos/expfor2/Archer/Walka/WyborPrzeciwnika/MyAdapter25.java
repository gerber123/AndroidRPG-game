package pl.marcinos.expfor2.Archer.Walka.WyborPrzeciwnika;

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
 * Created by marci on 17.05.2018.
 */

public class MyAdapter25 extends BaseAdapter
{


    private Context context;
    private List<Potwory> potworyList;
    private LayoutInflater layoutInflater;
//    int[] Images = {R.drawable.kot,R.drawable.wilkor,R.drawable.szkielet,R.drawable.zombie};
    public MyAdapter25(Context context, List<Potwory> potworyList)
    {
        this.context=context;
        this.potworyList=potworyList;

        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    public View getView(int position, View convertView, ViewGroup parent)
    {


        ViewHolder viewHolder;
        if(convertView==null)
        {
            viewHolder= new ViewHolder();
            convertView=layoutInflater.inflate(R.layout.customlayout,parent,false);
            viewHolder.name=(TextView)convertView.findViewById((R.id.textView_name));
            viewHolder.hp=(TextView)convertView.findViewById((R.id.textView_hp));
            viewHolder.atk=(TextView)convertView.findViewById((R.id.textView_atk));
            viewHolder.lvl=(TextView)convertView.findViewById((R.id.textView_lvl));
            viewHolder.img=(ImageView)convertView.findViewById((R.id.imageView2));


            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder =  (ViewHolder)convertView.getTag();
        }


        viewHolder.name.setText(potworyList.get(position).getName());
        viewHolder.hp.setText("Hp: "+potworyList.get(position).getHp());
        viewHolder.atk.setText("Atk: "+potworyList.get(position).getAtkDoListy());
        viewHolder.lvl.setText("Lvl: "+potworyList.get(position).getLvl());


           viewHolder.img.setImageResource(potworyList.get(position).getImageAvatar());

        return convertView;
    }
    class ViewHolder
    {
        TextView lvl;
        TextView name;
        TextView hp;
        TextView atk;
        ImageView img;

    }
}
