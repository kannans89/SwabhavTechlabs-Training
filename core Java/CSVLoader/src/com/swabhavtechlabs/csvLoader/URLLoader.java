package com.swabhavtechlabs.csvLoader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class URLLoader implements ILoader {

	@Override
	public List<String> load() {
		List<String> records = new ArrayList<>();
		String urlCall = "https://swabhav-tech.firebaseapp.com/emp.txt";
		try {
			URL url = new URL(urlCall);
			URLConnection urlConnection = url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				records.add(line);
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return records;
	}
}
