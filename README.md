# coleta-de-dados-tcu
Mini projeto para coletar dados em Api do tribunal de contas e salvar em um banco de dados.

<h1>AcordaoController</h1>

<h2>Buscar e Salvar Acordãos</h2>

<p><strong>Descrição:</strong> Busca acórdãos da API pública do TCU com base no número e quantidade fornecidos e salva-os no repositório.</p>

<h3>URL</h3>
<p>/acordao/{num}/{quantidade}</p>

<h3>Método</h3>
<p>GET</p>

<h3>Parâmetros de Caminho (Path Parameters)</h3>
<table>
  <tr>
    <th>Parâmetro</th>
    <th>Tipo</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>num</td>
    <td>Long</td>
    <td>O número de partida para a busca dos acórdãos.</td>
  </tr>
  <tr>
    <td>quantidade</td>
    <td>Long</td>
    <td>A quantidade de acórdãos a serem buscados e salvos.</td>
  </tr>
</table>

<h3>Respostas</h3>
<p>O método não retorna uma resposta explícita.</p>


<h1>AcordaoService</h1>

<h2>Encontrar Acórdãos</h2>

<p><strong>Descrição:</strong> Busca acórdãos na API pública do TCU com base no número e quantidade fornecidos.</p>

<h3>Parâmetros</h3>
<table>
  <tr>
    <th>Parâmetro</th>
    <th>Tipo</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>num</td>
    <td>Long</td>
    <td>O número de partida para a busca dos acórdãos.</td>
  </tr>
  <tr>
    <td>quantidade</td>
    <td>Long</td>
    <td>A quantidade de acórdãos a serem buscados.</td>
  </tr>
</table>

<h3>Retorno</h3>
<p>Uma lista de objetos Acordao com os dados dos acórdãos encontrados.</p>

<h1>TermosContratuaisController</h1>

<h2>Listar e Salvar Termos Contratuais</h2>

<p><strong>Descrição:</strong> Lista os termos contratuais da API pública do TCU e os salva no repositório.</p>

<h3>URL</h3>
<p>/termos-contratuais/listar</p>

<h3>Método</h3>
<p>GET</p>

<h3>Respostas</h3>
<p>O método não retorna uma resposta explícita.</p>


<h1>TermosContratuaisService</h1>

<h2>Retornar Termos Contratuais</h2>

<p><strong>Descrição:</strong> Retorna os termos contratuais da API pública do TCU.</p>

<h3>Retorno</h3>
<p>Uma lista de objetos TermosContratuais com os dados dos termos contratuais encontrados.</p>
