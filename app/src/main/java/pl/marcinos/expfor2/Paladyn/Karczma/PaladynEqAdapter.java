package pl.marcinos.expfor2.Paladyn.Karczma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pl.marcinos.expfor2.Bohaterowie.Itemy;
import pl.marcinos.expfor2.Metody.Set;
import pl.marcinos.expfor2.R;

import static pl.marcinos.expfor2.Archer.Menu.ArcherMenuActivity.archer;
import static pl.marcinos.expfor2.Paladyn.Menu.PaladynMenuActivity.paladyn;

public class PaladynEqAdapter extends BaseAdapter {

    private Context context;
    private List<Itemy> EqList;
    private LayoutInflater layoutInflater;

    int[] Items = {R.drawable.kamien,R.drawable.archera,R.drawable.archer,R.drawable.archerd};



    public PaladynEqAdapter(Context context, List<Itemy> EqList)
    {
        this.context=context;
        this.EqList=EqList;

        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return EqList.size();
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
            viewHolder=new ViewHolder();
            convertView=layoutInflater.inflate(R.layout.paladyn_eq_adapter,parent,false);
            viewHolder.Nick=(TextView)convertView.findViewById((R.id.textView_name));
            viewHolder.Ilosc=(TextView)convertView.findViewById((R.id.textView_wartosc));
            viewHolder.Wartosc=(TextView)convertView.findViewById((R.id.textView_ilosc));
            viewHolder.opis=(TextView)convertView.findViewById((R.id.textView_opis));
            viewHolder.img=(ImageView)convertView.findViewById((R.id.imageView2));


            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder =  (ViewHolder)convertView.getTag();
        }

            viewHolder.img.setImageResource(EqList.get(position).getSciezkaDoObrazka());
            viewHolder.Nick.setText(EqList.get(position).getNazwaItema()+" ");

            viewHolder.Wartosc.setText("Wartość: "+EqList.get(position).getWartoscItema()+" złota");



         if(EqList.get(position).getNazwaItema().equalsIgnoreCase("Gold"))
        {

            viewHolder.Ilosc.setText("Ilość: "+paladyn.getHajs());
            viewHolder.opis.setText("Opis: Możesz kupować złotem w sklepie ");
            viewHolder.Wartosc.setText(("Wartość: unikalna"));
        }
        else if(EqList.get(position).getNazwaItema().equalsIgnoreCase("Set"))
        {
            viewHolder.Nick.setText(EqList.get(position).getNazwaWlasna());
            viewHolder.Ilosc.setText("Jedna sztuka");
            viewHolder.Wartosc.setText("Jakoś: Unikalna");
            viewHolder.opis.setText("Opis: "+EqList.get(position).getOpis());
        }
        else if(EqList.get(position).getNazwaItema().equalsIgnoreCase("Wep"))
        {

            viewHolder.Nick.setText(EqList.get(position).getNazwaWlasna());
            viewHolder.Ilosc.setText("Jedna sztuka ");
            viewHolder.Wartosc.setText("Jakoś: Unikalna");
            viewHolder.opis.setText("Opis: "+EqList.get(position).getOpis());
        }
        else if(EqList.get(position).getNazwaItema().equalsIgnoreCase("Kamien"))
        {
//            viewHolder.Nick.setText(EqList.get(position).getNazwaWlasna());
            viewHolder.Ilosc.setText("Ilość: "+paladyn.getIloscKamieni());
            viewHolder.Wartosc.setText("Wartość: 150 złota ");
            viewHolder.opis.setText("Opis: "+EqList.get(position).getOpis());
        }

         else if(EqList.get(position).getNazwaItema().equalsIgnoreCase("Kolczyk Lajamira"))
         {
             viewHolder.Nick.setText(EqList.get(position).getNazwaItema());
             viewHolder.Ilosc.setText("Jedna sztuka ");
             viewHolder.Wartosc.setText("Jakoś: Unikalna");
             viewHolder.opis.setText("Opis: "+EqList.get(position).getOpis());
         }
         else if(EqList.get(position).getNazwaItema().equalsIgnoreCase("Pierścien Volda"))
         {
             viewHolder.Nick.setText(EqList.get(position).getNazwaItema());
             viewHolder.Ilosc.setText("Jedna sztuka ");
             viewHolder.Wartosc.setText("Jakoś: Unikalna");
             viewHolder.opis.setText("Opis: "+EqList.get(position).getOpis());
         }
         else if(EqList.get(position).getNazwaItema().equalsIgnoreCase("Naszyjnik Torosa"))
         {
             viewHolder.Nick.setText(EqList.get(position).getNazwaItema());
             viewHolder.Ilosc.setText("Jedna sztuka ");
             viewHolder.Wartosc.setText("Jakoś: Unikalna");
             viewHolder.opis.setText("Opis: "+EqList.get(position).getOpis());
         }

        else if(EqList.get(position).getNazwaItema().equalsIgnoreCase("Diament"))
        {
//            viewHolder.Nick.setText(EqList.get(position).getNazwaWlasna());
            viewHolder.Ilosc.setText("Ilość: "+paladyn.getIloscKamieniPewnych());
            viewHolder.Wartosc.setText("Wartość: Bezcenny");
            viewHolder.opis.setText("Opis: "+EqList.get(position).getOpis());
        }
        else if(EqList.get(position).getNazwaItema().equalsIgnoreCase("Monument"))
        {
//            viewHolder.Nick.setText(EqList.get(position).getNazwaWlasna());
            viewHolder.Ilosc.setText("Ilość: "+paladyn.getIloscMonumentow());
            viewHolder.Wartosc.setText("Wartość: Bezcenny");
            viewHolder.opis.setText("Opis: "+EqList.get(position).getOpis());
        }
        else if(EqList.get(position).getNazwaItema().equalsIgnoreCase("Klucz"))
        {
//            viewHolder.Nick.setText(EqList.get(position).getNazwaWlasna());
            viewHolder.Ilosc.setText("Ilość: "+paladyn.getIloscKluczy());
            viewHolder.Wartosc.setText("Wartość: Bezcenny");
            viewHolder.opis.setText("Opis: "+EqList.get(position).getOpis());
        }
        else
        {
            viewHolder.Ilosc.setText("Ilość: "+EqList.get(position).getIloscItemow()+" ");
            viewHolder.opis.setText("Opis: "+EqList.get(position).getOpis());
        }


        return convertView;
    }
    class ViewHolder
    {

        TextView Nick;
        TextView Wartosc;
        TextView Ilosc;
        TextView opis;


        ImageView img;

    }
}

