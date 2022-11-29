package com.belajar.asyncpraktikum;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AscyncTask extends AsyncTask<Void,Integer,String> {

    Context context;
    ProgressBar progressBar;

    public AscyncTask(Context ct, ProgressBar pb) {
        context = ct;
        progressBar = pb;
    }

    // dipanggil  saat sebelum eksekusi background thread
    // biasanya digunakan untuk menaruh tampilan progress dari background thread
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setMax(10);

    }

    // menjalankan background thread, fun ini dijalankan setelah onPreExecute()
    @Override
    protected String doInBackground(Void... voids) {
        // simulasi loading, menggunakan for dengan maksimal perulangan <=10
        try {
                for (int i = 0; i <= 10; i++) {
                    // jeda perulangan 7000ms
                    Thread.sleep(7000);
                    // Log Debug untuk cek apakah value sesuai dengan yang diinginkan
                    Log.d("Progress Loading", String.valueOf(i));
                    // kirim integer i kedalam argumen onProgress Update
                    publishProgress(i);
                }
                return "Sucess";
        } catch (Exception e) {
            Log.d("Error Message",e.getMessage());
            return "Failure";
        }

    }



    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        // get nilai values, values bernilai array Int
        int loadingValue = values[0];
        // set progressbar dengan nilai dari values
        progressBar.setProgress(loadingValue);
    }

    // fun untuk ekekusi jika backgroundTask sudah selesai
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }


}
