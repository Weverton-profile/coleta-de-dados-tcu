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

import br.com.apitcu.model.TermosContratuais;

@Service
public class TermosContratuaisService {
	
	public List<TermosContratuais> retornarTermos() {
		List<TermosContratuais> termosContratuais = new ArrayList<>();
		HttpGet request = new HttpGet("https://contas.tcu.gov.br/contrata2RS/api/publico/termos-contratuais");
		try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
				CloseableHttpResponse response = httpClient.execute(request)) {
			
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				JSONArray jsonArray = new JSONArray(result);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					termosContratuais.add(new TermosContratuais(jsonObject.isNull("tipoContratacao") ? null : jsonObject.getString("tipoContratacao"),
							jsonObject.isNull("numero") ? null : jsonObject.getLong("numero"),
							jsonObject.isNull("ano") ? null : jsonObject.getLong("ano"),
							jsonObject.isNull("unidadeGestora") ? null : jsonObject.getString("unidadeGestora"),
							jsonObject.isNull("nomeFornecedor") ? null : jsonObject.getString("nomeFornecedor"),
							jsonObject.isNull("cnpjFornecedor") ? null : jsonObject.getString("cnpjFornecedor"),
							jsonObject.isNull("objeto") ? null : jsonObject.getString("objeto"),
							jsonObject.isNull("valorInicial") ? null : jsonObject.getBigDecimal("valorInicial"),
							jsonObject.isNull("numeroProcesso") ? null : jsonObject.getString("numeroProcesso"),
						    jsonObject.isNull("modalidadeLicitacao") ? null : jsonObject.getString("modalidadeLicitacao"),
						    jsonObject.isNull("valorInicial") ? null : jsonObject.getBigDecimal("valorAtualizado")));
				}
			}
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return termosContratuais;
	}
	
}
