package aplikasi.mobile.listviewimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Menu_Daftar_Makanan extends AppCompatActivity {

    ListView lvItem;
    EditText Edtcari;
    ListViewAdapterCall adapter;
    ArrayList<ListViewAdapterMenu> arraylist = new ArrayList<ListViewAdapterMenu>();

    int[] Gambar;
    String[] NamaItem;
    String[] HargaItem;
    String[] Deskripsi;
    String[] NomorHP;
    String[] Lat;
    String[] Long;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_daftar_makanan);

        lvItem		= (ListView)findViewById(R.id.listView1);
        Edtcari     = (EditText)findViewById(R.id.editText1);


        Gambar		= new int[]{
                R.mipmap.jambu,
                R.mipmap.pisang,
                R.mipmap.salak,
                R.mipmap.melon,
                R.mipmap.blimbing};

        NamaItem 	= new String[]{
                "Buah Jambu ",
                "Buah Pisang",
                "Buah Salak",
                "Buah Melon",
                "Buah Blimbing"};

        HargaItem 	= new String[]{
                "Harga Dari 5000-50000 Rupiah",
                "Harga Dari 20000-1000000 Rupiah",
                "Harga Dari 15000-80000 Rupiah",
                "Harga Dari 45000-70000 Rupiah",
                "Harga Dari 13000-100000 Rupiah"};

        Deskripsi 	= new String[]{
                "Jambu biji getas merah adalah varian jambu biji yang berdaging hijau sampai kekuning-kuningan dan berisi merah muda..",

                "Pisang adalah tanaman buah berupa herba yang berasal dari kawasan di Asia Tenggara.",

                "Salak adalah sejenis palma dengan buah yang biasa dimakan. Ia dikenal juga sebagai sala. Dalam bahasa Inggris disebut salak atau snake fruit, sementara nama ilmiahnya adalah Salacca zalacca..",

                "Melon (Cucumis melo L.) merupakan tanaman buah termasuk famili Cucurbitaceae, banyak yang menyebutkan buah melon berasal dari Lembah Panas Persia atau daerah Mediterania yang merupakan perbatasan antara Asia Barat dengan Eropa dan Afrika..",

                "Belimbing atau Averrhoa carambola adalah buah yang populer di iklim tropis. Buah ini dikenal dengan rasa asam-manisnya yang khas dan menyegarkan. Tak hanya itu, belimbing bahkan merupakan salah satu buah yang sering digunakan sebagai pengobatan ayurveda di India, Cina, dan Brazil.."};
				

        NomorHP  = new String[]{
                "+6289899760780",
                "+6289899760780",
                "+6289899760780",
                "+6289899760780",
                "+6289899760780",
        };

        Lat  = new String[]{
                "-7.0268812",
                "-7.0268812",
                "-7.0268812",
                "-7.0268812",
                "-7.0268812"
        };

        Long  = new String[]{
                "110.424669",
                "110.424669",
                "110.424669",
                "110.424669",
                "110.424669"
        };


        for (int i = 0; i < NamaItem.length; i++)
        {
            ListViewAdapterMenu wp = new ListViewAdapterMenu(NamaItem[i], HargaItem[i], Deskripsi[i], Gambar[i], NomorHP[i], Lat[i], Long[i]);
            arraylist.add(wp);
        }

        adapter = new ListViewAdapterCall(this, arraylist);
        lvItem.setAdapter(adapter);

        Edtcari.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                String text = Edtcari.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
                showToastMessage("Pencarian dilakukan");
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
        });

    }

    void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
