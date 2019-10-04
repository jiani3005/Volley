package com.mykotlinapplication.kotlin34.activities

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.mykotlinapplication.kotlin34.R
import com.mykotlinapplication.kotlin34.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import javax.net.ssl.HttpsURLConnection


class MainActivity : AppCompatActivity() {

//    var contactList = arrayListOf<HashMap<String, String>>()
//    val url = URL("https://api.androidhive.info/contacts/")
    var recyclerViewAdapter: RecyclerViewAdapter? = null

    var contactList = arrayListOf<Triple<String, String, String>>()
//    var email = arrayListOf<String>()
//    var phone = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val jsonString = makeServiceCall(url)
//        convertJSONtoContact(jsonString)

//        GetContacts().execute(url)
//        getContacts()

//        addInfo()



        recyclerView.layoutManager = LinearLayoutManager(this)
        var strReq = StringRequest(Request.Method.POST, "https://api.androidhive.info/contacts/",
            Response.Listener {
                var jsonObject = JSONObject(it)
                var jsonArrayContact = jsonObject.getJSONArray("contacts")

                for (i in 0 until (jsonArrayContact.length())) {
                    var contact = jsonArrayContact.getJSONObject(i)

                    var id = contact.getString("id")
                    var name = contact.getString("name")
                    var gender = contact.getString("gender")

                    contactList.add(Triple(id, name, gender))
                }
                val adapter = RecyclerViewAdapter(contactList, this)
                recyclerView.adapter = adapter
            }, Response.ErrorListener {  })
//
//        recyclerView.adapter = RecyclerViewAdapter(names, email, phone, this)

        var reqQueue = Volley.newRequestQueue(this)
        reqQueue.add(strReq)



    }





//    fun addInfo() {
//        names.add("Jack")
//        email.add("jack@gmail.com")
//        phone.add("1234567890")
//
//        names.add("Paul")
//        email.add("paul@gmail.com")
//        phone.add("9987654321")
//
//        names.add("Harper")
//        email.add("harper@gmail.com")
//        phone.add("4719749191")
//    }



//    fun getContacts() {
//        // Instantiate the RequestQueue.
//        val queue = Volley.newRequestQueue(this)
//        val url: String = "https://api.androidhive.info/contacts/"
//
//        // Request a string response from the provided URL.
//        val stringReq = StringRequest(Request.Method.GET, url,
//            Response.Listener<String> { response ->
//
//                var strResp = response.toString()
//                convertJSONtoContact(strResp)
//            },
//            Response.ErrorListener { textView_wait!!.text = "That didn't work!" })
//        queue.add(stringReq)
//    }
//
//    fun makeServiceCall(reqUrl: URL): String {
//
//        var response:String? = null
////        val url = URL(reqUrl)
//        val conn = reqUrl.openConnection() as HttpURLConnection
//        conn.setRequestMethod("GET")
//        // read the response
//        val buffer = BufferedInputStream(conn.getInputStream())
//        response = convertStreamToString(buffer)
//
//
//        return response
//    }
//
//    fun convertStreamToString(input: InputStream): String {
//        val reader = BufferedReader(InputStreamReader(input))
//        val sb = StringBuilder()
//
//        var line: String? = null
//        do {
//            line = reader.readLine()
//            sb.append(line).append('\n')
//        } while (line != null)
//
//        return sb.toString()
//    }
//
//    fun convertJSONtoContact (jsonStr:String) {
//        var jsonObj = JSONObject(jsonStr)
//
//        var jsonArray = jsonObj.getJSONArray("contacts")
//        for (i in 0..jsonArray.length()-1) {
//            var c = jsonArray.getJSONObject(i)
//
//            var id = c.getString("id")
//            var name = c.getString("name")
//            var email = c.getString("email")
//            var address = c.getString("address")
//            var gender = c.getString("gender")
//
//            var phones = c.getJSONObject("phone")
//            var mobile = phones.getString("mobile")
//            var home = phones.getString("home")
//            var office = phones.getString("office")
//
//            var contact = HashMap<String, String>()
//            contact.put("id", id)
//            contact.put("name", name)
//            contact.put("email", email)
//            contact.put("mobile", mobile)
//
//            contactList.add(contact)
//        }
//        Log.i("datapass", "contactList.size = ${contactList.size}")
////        recyclerViewAdapter?.setData(contactList)
//    }
//
//    inner class GetContacts: AsyncTask<URL, Void, Void>() {
//
//        override fun onPreExecute() {
//            super.onPreExecute()
//            textView_wait.text = "Please wait..."
//            textView_wait.visibility = View.VISIBLE
//        }
//
//        override fun doInBackground(vararg params: URL?): Void? {
//            val result = makeServiceCall(url)
//
//            convertJSONtoContact(result)
//
//            return null
//        }
//
//        override fun onProgressUpdate(vararg values: Void?) {
//            super.onProgressUpdate(*values)
//        }
//
//        override fun onPostExecute(result: Void?) {
//            super.onPostExecute(result)
////            recyclerViewAdapter?.setData(contactList)
//            textView_wait.text = "Finish converted"
//            textView_wait.visibility = View.GONE
//        }
//
//    }

}
