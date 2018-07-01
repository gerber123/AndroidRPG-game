package pl.marcinos.expfor2.Archer.Menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import pl.marcinos.expfor2.Model.User;
import pl.marcinos.expfor2.R;

/**
 * Created by marci on 07.05.2018.
 */

public class AdapterFinal extends BaseAdapter {

    private Context context;
    private List<User> BohaterowieList;
    private LayoutInflater layoutInflater;
    int[] ImagesArcher = {R.drawable.archerb,R.drawable.archera,R.drawable.archer,R.drawable.archerd};
    int[] ImagesMag = {R.drawable.wizardb,R.drawable.wizarda,R.drawable.wizard,R.drawable.wizardd};
    int[] ImagesPaladyn = {R.drawable.paladynbb,R.drawable.paladyna,R.drawable.paladyn,R.drawable.paladynd};


    public AdapterFinal(Context context, List<User> potworyList)
    {
        this.context=context;
        this.BohaterowieList=potworyList;

        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return BohaterowieList.size();
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
            convertView=layoutInflater.inflate(R.layout.customranking,parent,false);
            viewHolder.Nick=(TextView)convertView.findViewById((R.id.textView_nick));
            viewHolder.Lvl=(TextView)convertView.findViewById((R.id.textView_lvl));
            viewHolder.Exp=(TextView)convertView.findViewById((R.id.textView_exp));
            viewHolder.Klasa=(TextView)convertView.findViewById((R.id.textView_klasa));
            viewHolder.Honor=(TextView)convertView.findViewById((R.id.textView_hajs));

            viewHolder.img=(ImageView)convertView.findViewById((R.id.imageView2));


            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder =  (ViewHolder)convertView.getTag();
        }



        viewHolder.Nick.setText("Nick: "+BohaterowieList.get(position).getUserName());
        viewHolder.Klasa.setText("Klasa: "+BohaterowieList.get(position).getNazwa());
        viewHolder.Lvl.setText("Lvl: "+BohaterowieList.get(position).getLvl());
        viewHolder.Exp.setText("Exp: "+BohaterowieList.get(position).getExp()+"/"+BohaterowieList.get(position).getMaxexp());
        viewHolder.Honor.setText("Honor: "+BohaterowieList.get(position).getPunktyHonoru());


        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("mag")&&BohaterowieList.get(position).getSett()==1)
        {
                   viewHolder.img.setImageResource(ImagesMag[0]);
        }
        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("mag")&&BohaterowieList.get(position).getSett()==2)
        {
            viewHolder.img.setImageResource(ImagesMag[1]);
        }
        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("mag")&&BohaterowieList.get(position).getSett()==3)
        {
            viewHolder.img.setImageResource(ImagesMag[2]);
        }
        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("mag")&&BohaterowieList.get(position).getSett()==4)
        {
            viewHolder.img.setImageResource(ImagesMag[3]);
        }
        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("archer")&&BohaterowieList.get(position).getSett()==1)
        {
            viewHolder.img.setImageResource(ImagesArcher[0]);
        }
        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("archer")&&BohaterowieList.get(position).getSett()==2)
        {
            viewHolder.img.setImageResource(ImagesArcher[1]);
        }
        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("archer")&&BohaterowieList.get(position).getSett()==3)
        {
            viewHolder.img.setImageResource(ImagesArcher[2]);
        }
        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("archer")&&BohaterowieList.get(position).getSett()==4)
        {
            viewHolder.img.setImageResource(ImagesArcher[3]);
        }
        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("paladyn")&&BohaterowieList.get(position).getSett()==1)
        {
            viewHolder.img.setImageResource(ImagesPaladyn[0]);
        }
        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("paladyn")&&BohaterowieList.get(position).getSett()==2)
        {
            viewHolder.img.setImageResource(ImagesPaladyn[1]);
        }
        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("paladyn")&&BohaterowieList.get(position).getSett()==3)
        {
            viewHolder.img.setImageResource(ImagesPaladyn[2]);
        }
        if(BohaterowieList.get(position).getNazwa().equalsIgnoreCase("paladyn")&&BohaterowieList.get(position).getSett()==4)
        {
            viewHolder.img.setImageResource(ImagesPaladyn[3]);
        }

//        viewHolder.img.setImageResource(BohaterowieList.get(position).getImageAvatar());
//        viewHolder.img.setImageResource(Images[position]);

        return convertView;
    }
    class ViewHolder
    {

        TextView Nick;
        TextView Lvl;
        TextView Exp;
        TextView Klasa;
        TextView Honor;


        ImageView img;

    }
}
