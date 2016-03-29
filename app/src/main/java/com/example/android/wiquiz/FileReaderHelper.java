package com.example.android.wiquiz;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by raghu on 24/3/16.
 */
public class FileReaderHelper {




    public String readData(Context context) throws IOException
    {
        String str;
        StringBuffer buf= new StringBuffer();
        InputStream is=context.getResources().openRawResource(R.raw.datajson);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null) {
            while ((str = reader.readLine()) != null) {
                buf.append(str + "\n" );
            }
        }
        is.close();

        return buf.toString();
    }


}
