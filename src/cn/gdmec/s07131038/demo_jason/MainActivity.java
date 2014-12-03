package cn.gdmec.s07131038.demo_jason;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /*try {
			JSONObject person = new JSONObject();
			person.put("name", "lisi");
			person.put("age", 18);
			
			JSONArray phones = new JSONArray();
			phones.put("123456").put("7654321");
			
			person.put("phones", phones);
			
			String JsonDate = person.toString();
			
			Log.i("info", JsonDate);
		} catch (JSONException e) {	
			e.printStackTrace();
		}*/
        String s=null;
        try {
			JSONStringer jsonStringer =new JSONStringer();
			jsonStringer.object();
			jsonStringer.key("name").value("zhangsan");
			jsonStringer.key("age").value(19);
			
			jsonStringer.key("phones");
			jsonStringer.array();
			jsonStringer.value("123456").value("65465164");
			jsonStringer.endArray();
			
			jsonStringer.endObject();
			
			s=jsonStringer.toString();
			
			Log.i("info", s);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			JSONObject person =new JSONObject(s);
			String name = person.getString("name");
			int age = person.getInt("age");
			
			JSONArray phones = person.getJSONArray("phones");
			String phone1=phones.getString(0);
			String phone2=phones.getString(1);
			
			List<String> numbers=new ArrayList<String>();
			numbers.add(phone1);
			numbers.add(phone2);
			
			Person p =new Person(name, age, numbers);
			
			Log.i("info", "生成的JAVA对象"+p.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }


}
