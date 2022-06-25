package com.nurettingorsoy.baseadapter_customlistview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nurettingorsoy.baseadapter_customlistview.Model.Unluler;
import com.nurettingorsoy.baseadapter_customlistview.R;

import java.util.List;

public class ListeAdapter extends BaseAdapter {

    private List<Unluler> unluler;
    private Context context;
    private LayoutInflater layoutInflater;
    /*
    layoutInflater sınıfı sayesınde adapter içerisinde kullanacağımız xml layout
    dosyasını tanımlayabiliriz.
     */
    public ListeAdapter(){}

    public ListeAdapter(List<Unluler> unluler, Context context){
        /*
        Dolu constructor'u üretme amacımız Adapter sınıfını çağıracağımız Activity
        sınıfında Adapter'ın List<Unluler> değerini Activity'den çağırmaktır.
         */
        this.unluler = unluler;
        this.context = context;
        layoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        //listenin eleman sayısı kadar değer döndürür.
        //listview içerisinde kaç tane değer göstereceğim bilgisini getCount içerisinde return edeceğim değer belirliyor.
        return unluler.size();
    }

    @Override
    public Object getItem(int position) {
        //Listview'in kaçıncı satırda olduğu bilgisini döndürüyor.Listenin kaçıncı değerindeysek,ilgili satırı Object olarak döndürür.
        return unluler.get(position); //unluler tipinde bir class dönduruyor object donduruyor.
    }

    @Override
    public long getItemId(int position) {
        //Bulunduğumuz satırın indisini yakalamak amacıyla kullanabiliriz.
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        Satır görüntüsünün üretilmesi, satır içerisindeki nesnelerin tanımlanması
        ve nesne olaylarını tanımlamak amaçlı kullanılır.
         */

        View v = layoutInflater.inflate(R.layout.listview_satir_goruntusu,null);

        ImageView imageView = v.findViewById(R.id.imageView);
        TextView textView,textView1,textView2;
        textView = v.findViewById(R.id.textView);
        textView1 = v.findViewById(R.id.textView1);
        textView2 = v.findViewById(R.id.textView2);

        //yerlerini array listten dolduralım

        textView.setText(unluler.get(position).getAdSoyad());
        textView1.setText(unluler.get(position).getSehir());
        textView2.setText(""+unluler.get(position).getDogumYili());
        Glide
                .with(v.getContext())
                .load(unluler.get(position).getResimUrl())
                .into(imageView);
        /*
        Glide kutuphanesi:
        - Bir resim web üzerindeki url'den yükleyio, ImageView içerisinde göstermek
        istiyorsak, Glide kullanabilriiz.
        - Image Caching işlemi sayesinde resimleri hızlı açar.
         */

        return v;
    }
}
