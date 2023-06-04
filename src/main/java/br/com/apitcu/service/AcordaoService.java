package br.com.apitcu.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import br.com.apitcu.model.Acordao;

@Service
public class AcordaoService {
	
	public List<Acordao> encontrarAcordaos(Long num, Long quantidade) {
		List<Acordao> acordaos = new ArrayList<>();
		HttpGet request = new HttpGet("https://dados-abertos.apps.tcu.gov.br/api/acordao/recupera-acordaos?inicio=" + num +"&quantidade=" + quantidade);
		try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
				CloseableHttpResponse response = httpClient.execute(request)) {
			
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				JSONArray jsonArray = new JSONArray(result);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					acordaos.add(new Acordao(jsonObject.isNull("key") ? null : jsonObject.getString("key"), 
							jsonObject.isNull("tipo") ? null : jsonObject.getString("tipo"), 
							jsonObject.isNull("anoAcordao") ? null : jsonObject.getString("anoAcordao"),
							jsonObject.isNull("titulo") ? null : jsonObject.getString("titulo"), 
							jsonObject.isNull("numeroAcordao") ? null : jsonObject.getString("numeroAcordao"), 
							jsonObject.isNull("numeroAta") ? null : jsonObject.getString("numeroAta"),
							jsonObject.isNull("colegiado") ? null : jsonObject.getString("colegiado"), 
							jsonObject.isNull("dataSessao") ? null : jsonObject.getString("dataSessao"),
							jsonObject.isNull("relator") ? null : jsonObject.getString("relator"),
							jsonObject.isNull("situacao") ? null : jsonObject.getString("situacao"),
							jsonObject.isNull("sumario") ? null : jsonObject.getString("sumario"), 
							jsonObject.isNull("urlArquivo") ? null : jsonObject.getString("urlArquivo"),
							jsonObject.isNull("urlArquivoPdf") ? null : jsonObject.getString("urlArquivoPdf"),
							jsonObject.isNull("urlAcordao") ? null : jsonObject.getString("urlAcordao")));
				}
			}
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return acordaos;
	}
	
}
